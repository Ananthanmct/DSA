# Assignment: Enterprise-grade Application Deployment and Hardening on Kubernetes

## Project Title: Deploying a Secure Multi-Tier Application Using Helm on Kubernetes

---

## Objective

Gain hands-on Kubernetes experience by deploying a prebuilt, multi-tier application using Helm and applying best practices in configuration management, security, and persistence.

---

## Provided Stack

You will use the following prebuilt container images:

* **nginx**: Frontend
* **redis**: In-memory cache
* **postgres**: Persistent database

> A basic starter Helm chart structure and `values.yaml` will be provided.

---

## Application Stack Folder Structure

```bash
enterprise-app/
├── charts/
│   ├── nginx/
│   ├── redis/
│   └── postgres/
├── templates/
├── values.yaml
├── Chart.yaml
└── README.md
```

---

## 1. Helm Chart Packaging

### Using Helm CLI

```bash
helm create enterprise-app
```

* Move all relevant templates under `charts/nginx`, `charts/redis`, and `charts/postgres`
* Update parent `Chart.yaml` to include subcharts:

```yaml
dependencies:
  - name: nginx
    version: 0.1.0
    repository: file://charts/nginx
  - name: redis
    version: 0.1.0
    repository: file://charts/redis
  - name: postgres
    version: 0.1.0
    repository: file://charts/postgres
```

---

## 2. Configuration Management

### ConfigMap for nginx

```bash
kubectl create configmap nginx-config --from-file=nginx.conf
```

Use it in Deployment:

```yaml
volumeMounts:
- mountPath: /etc/nginx/nginx.conf
  name: nginx-config
  subPath: nginx.conf
volumes:
- name: nginx-config
  configMap:
    name: nginx-config
```

### Secret for PostgreSQL

```bash
kubectl create secret generic postgres-secret \
  --from-literal=POSTGRES_USER=admin \
  --from-literal=POSTGRES_PASSWORD=secret \
  --from-literal=POSTGRES_DB=mydb
```

Use in Deployment:

```yaml
env:
- name: POSTGRES_USER
  valueFrom:
    secretKeyRef:
      name: postgres-secret
      key: POSTGRES_USER
```

---

## 3. Probes and Health Checks

### nginx

```yaml
livenessProbe:
  httpGet:
    path: /
    port: 80
  initialDelaySeconds: 10
readinessProbe:
  httpGet:
    path: /
    port: 80
  initialDelaySeconds: 5
```

### redis / postgres

```yaml
livenessProbe:
  tcpSocket:
    port: 6379 # or 5432 for postgres
readinessProbe:
  tcpSocket:
    port: 6379 # or 5432 for postgres
```

---

## 4. Network Policies

### Default Deny Policy

```yaml
apiVersion: networking.k8s.io/v1
kind: NetworkPolicy
metadata:
  name: default-deny
spec:
  podSelector: {}
  policyTypes:
  - Ingress
```

### Allow nginx to redis/postgres

```yaml
apiVersion: networking.k8s.io/v1
kind: NetworkPolicy
metadata:
  name: allow-nginx-to-backend
spec:
  podSelector:
    matchLabels:
      app: redis # or postgres
  ingress:
  - from:
    - podSelector:
        matchLabels:
          app: nginx
    ports:
    - protocol: TCP
      port: 6379 # or 5432 for postgres
```

---

## 5. RBAC Configuration

### Create Service Account

```bash
kubectl create serviceaccount app-deployer
```

### Create Role

```yaml
kind: Role
apiVersion: rbac.authorization.k8s.io/v1
metadata:
  name: app-role
rules:
- apiGroups: [""]
  resources: ["pods", "services"]
  verbs: ["get", "list", "create"]
```

### Create RoleBinding

```yaml
kind: RoleBinding
apiVersion: rbac.authorization.k8s.io/v1
metadata:
  name: app-binding
subjects:
- kind: ServiceAccount
  name: app-deployer
  namespace: default
roleRef:
  kind: Role
  name: app-role
  apiGroup: rbac.authorization.k8s.io
```

### Use ServiceAccount in Deployment

```yaml
serviceAccountName: app-deployer
```

---

## 6. Persistent Volumes

### Local hostPath (Minikube or development only)

```yaml
apiVersion: v1
kind: PersistentVolume
metadata:
  name: local-pv
spec:
  capacity:
    storage: 1Gi
  accessModes:
    - ReadWriteOnce
  hostPath:
    path: "/mnt/data"
---
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: postgres-pvc
spec:
  accessModes:
    - ReadWriteOnce
  resources:
    requests:
      storage: 1Gi
```

### Dynamic provisioning (Cloud provider)

```yaml
apiVersion: v1
kind: PersistentVolumeClaim
metadata:
  name: postgres-pvc
spec:
  storageClassName: standard
  accessModes:
    - ReadWriteOnce
  resources:
    requests:
      storage: 1Gi
```

Mount in your Deployment:

```yaml
volumeMounts:
- name: db-storage
  mountPath: /var/lib/postgresql/data
volumes:
- name: db-storage
  persistentVolumeClaim:
    claimName: postgres-pvc
```

---

## 7. Backup Simulation with CronJob

```yaml
apiVersion: batch/v1
kind: CronJob
metadata:
  name: db-backup-job
spec:
  schedule: "0 2 * * *"
  jobTemplate:
    spec:
      template:
        spec:
          containers:
          - name: backup
            image: busybox
            command:
            - /bin/sh
            - -c
            - "echo Simulated backup > /mnt/backups/backup-$(date +%F).sql"
            volumeMounts:
            - name: db-volume
              mountPath: /mnt/backups
          restartPolicy: OnFailure
          volumes:
          - name: db-volume
            persistentVolumeClaim:
              claimName: postgres-pvc
```

---

## Deliverables

* GitHub repo with:

  * Helm chart with subcharts
  * YAMLs: ConfigMap, Secrets, PVC, NetworkPolicy, RBAC, Probes, CronJob

* Screenshots of:

  * `kubectl get all`
  * Helm release list (`helm list`)
  * Successful CronJob log (`kubectl logs <pod-name>`)

---

## Tips for Testing

```bash
kubectl create ns assignment
kubectl config set-context --current --namespace=assignment
```

You can test locally using **Minikube** or **Kind**.

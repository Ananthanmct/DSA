import os
import yaml

# Function to update key-value pairs in the airflow-app-config.yml file
def update_airflow_config(file_path, updates):
    try:
        # Open the YAML file and load its contents
        with open(file_path, 'r', encoding='utf-8') as f:
            data = yaml.safe_load(f)
        
        # Ensure the data is a dictionary before modifying
        if not isinstance(data, dict):
            return  # Skip files that do not contain a dictionary
        
        # Update the specified key-value pairs using while loop
        keys = list(updates.keys())
        i = 0
        while i < len(keys):
            key = keys[i]
            if key in data:
                data[key] = updates[key]
            i += 1
        
        # Write the updated data back to the file
        with open(file_path, 'w', encoding='utf-8') as f:
            yaml.safe_dump(data, f, default_flow_style=False)
    except Exception as e:
        print(f"Error processing {file_path}: {e}")

# Function to iterate through subdirectories and update airflow-app-config.yml files
def update_airflow_configs_in_folders(parent_folder, updates):
    subdirs = os.listdir(parent_folder)
    index = 0
    
    # Using a while loop to traverse the subdirectories
    while index < len(subdirs):
        subdir_path = os.path.join(parent_folder, subdirs[index])
        
        # Check if the path is a directory
        if os.path.isdir(subdir_path):
            config_file_path = os.path.join(subdir_path, 'configmaps/airflow-app-config.yml')
            
            # Check if the config file exists in the directory
            if os.path.exists(config_file_path):
                update_airflow_config(config_file_path, updates)
        
        index += 1  # Move to the next subdirectory

if __name__ == "__main__":
    # Define the parent directory containing the subdirectories
    parent_directory = "path/to/your/parent/folder"  # Change this to your parent folder path
    
    # Define the key-value pairs to be updated
    key_value_updates = {
        "EDP_ACQ_DAG_SD_ANR": "anything",
        "EDP_ACQ_DAG_SD_ACT": "anything",
        "EDP_ACQ_DAG_SD_IBOR": "anything"
    }
    
    # Call the function to update all airflow-app-config.yml files
    update_airflow_configs_in_folders(parent_directory, key_value_updates)
    print("Airflow config updates completed!")
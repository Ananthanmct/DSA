class Car:
    # variables that are creating inside the class are properties 
    # functions that are defined inside a class that are called methods or behaviours 
    wheels=4
    steringWheel=1
    engine="V8"
    gears=6
    currentGear=1



    def accelarateCar():
        print("Catr is acceleratiing")

    def changeGear(self, gearNum):
        self.currentGear = gearNum
        print(f"gear changed to {self.currentGear}")
    
    def playRadio():
        print("Radio played")

    def giveCurrentGear(self):
         print(f"current gear {self.currentGear}")


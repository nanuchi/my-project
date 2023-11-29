## This project was made to run under linux not windows or powershell. Can be force to run but who has time for that.
##### build the project

    ./gradlew build

##### build Docker image called java-app. Execute from root

    docker build -t java-app .
    
##### push image to repo 

    docker tag java-app demo-app:java-1.0
    

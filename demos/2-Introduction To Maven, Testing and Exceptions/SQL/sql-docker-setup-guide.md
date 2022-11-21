# How to Connect your PostGreSQL Docker Container to DBeaver
1. Install Docker Desktop.

2. Pull the PostGres image from DockerHub: ```docker pull postgres:latest```

You can verify that the image is now on your local machine using Docker Desktop under Images or running this command in terminal: ```docker images``` or ```docker image ls```.

3. Run the container to start PostGres:
```docker
docker run -d --name postgres13 
-v postgres_data:/var/lib/postgresql/data 
-e POSTGRES_USER=postgres 
-e POSTGRES_PASSWORD=postgres 
-p 5432:5432 
postgres:latest
```

>Tip: You should be able to check the logs of events occuring on your running docker container by running this command: ```docker logs [CONTAINER-ID]```

4. Create a new Connection in DBeaver that uses the port that container is on to run PostgreSQL:
    - Right-click and go to Create > Connection.

    - A new window will show up.

    - Select PostGreSQL (elephant symbol) as your database dialect. Click Next.

    - Fill in the following info:
        Host: localhost
        Port: 5432 (default for Postgres - change port if needed)
        Database: postgres
        Username: postgres
        Password: postgres

    - Click "Test Connection". Make sure you connect successfully.

    - Click Finish. 

5. Done! Now you can start writing some SQL in DBeaver. You can also install Postgres directly from the installation guide in the cohort repository.
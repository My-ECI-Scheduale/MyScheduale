FROM openjdk:11

WORKDIR /MyEciSchedule/back/bin


COPY /target/classes /MyEciSchedule/back/bin/classes

COPY /target/dependency /MyEciSchedule/back/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.eci.arsw.myecischedule.MyEciScheduleApplication"]
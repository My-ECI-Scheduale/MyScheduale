FROM openjdk:11

WORKDIR /MyEciScheduale/back/bin


COPY /target/classes /MyEciScheduale/back/bin/classes

COPY /target/dependency /MyEciScheduale/back/bin/dependency

CMD ["java","-cp","./classes:./dependency/*","edu.eci.arsw.myecischeduale.MyEciSchedualeApplication"]
Drop table HouseHold  cascade constraints;

Drop table Appliance  cascade constraints;
DROP SEQUENCE appliance_Seq;  

Drop table Measure  cascade constraints;

Drop SEQUENCE measure_Seq;

Drop table Sensor cascade constraints;

Drop SEQUENCE sensor_Seq;

DROP TABLE Measure_SQLLOADER;
 



     
CREATE  TABLE HouseHold (
  idHouseHold INT NOT NULL ,
  PRIMARY KEY (idHouseHold) );
     
CREATE  TABLE Appliance (
  idAppliance INT NOT NULL ,
  applianceName VARCHAR(45) NOT NULL ,
  applianceUnit VARCHAR(45) NULL ,
  PRIMARY KEY (idAppliance) );
  
CREATE SEQUENCE appliance_Seq
 INCREMENT BY 1    
     START WITH 1     
     NOMAXVALUE       
     NOCYCLE           
     CACHE 10; 
  
CREATE OR REPLACE TRIGGER appliance_Trigg BEFORE

INSERT ON Appliance FOR EACH ROW
BEGIN
SELECT appliance_Seq.nextval INTO:New.idAppliance FROM dual;	
	
END;
/


CREATE  TABLE Sensor (
  idSensor INT NOT NULL ,
  idSensorSec INT NOT NULL,
  descriptionSensor VARCHAR(255) NULL ,
  location VARCHAR(45) NULL ,
  idHouseHold INT NOT NULL ,
  idAppliance INT NOT NULL ,
  PRIMARY KEY (idSensor),
  CONSTRAINT fk_Sensor_HouseHold FOREIGN KEY (idHouseHold ) REFERENCES HouseHold (idHouseHold ),
  CONSTRAINT fk_Sensor_Appliance1 FOREIGN KEY (idAppliance ) REFERENCES Appliance (idAppliance ));
  
CREATE SEQUENCE sensor_Seq
INCREMENT BY 1    
     START WITH 1     
     NOMAXVALUE       
     NOCYCLE           
     CACHE 10; 

CREATE OR REPLACE TRIGGER sensor_Trigg BEFORE

INSERT ON Sensor FOR EACH ROW
BEGIN
SELECT sensor_Seq.nextval INTO:New.idSensor FROM dual;	
	
END;
/
     

CREATE  TABLE Measure (
  idSensor INT NOT NULL ,
  dateMeasure date NOT NULL,
  state INT NOT NULL ,
  energyValue INT NOT NULL ,
  CONSTRAINT pk_mesaure PRIMARY KEY (idSensor, dateMeasure),
  CONSTRAINT fk_Measure_Sensor1 FOREIGN KEY (idSensor ) REFERENCES Sensor (idSensor ));
  
  CREATE SEQUENCE measure_Seq;
  
  
  CREATE  TABLE Measure_SQLLOADER (
  dateMeasure varchar2(30) NOT NULL,
  heure varchar2(30) NOT NULL,
  state INT NOT NULL ,
  energyValue INT NOT NULL);

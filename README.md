
PCF
	https://apps.sys.pcfusc1dev.solutions.corelogic.com/
	
	cf login -a api.sys.pcfusc1dev.solutions.corelogic.com -o idap_data_pipelines_us-dev  -s clvtdatapipelines -u abarral@corelogic.com --skip-ssl-validation
	
	1. Create services for ELK such as syslog-drain and elastic-apm 
	https://confluence.corelogic.net/display/IDP/Application+Performance+Monitoring+%28APM%29+with+Elastic
	https://confluence.corelogic.net/display/IDP/ELK+App+Logging
	https://confluence.corelogic.net/pages/viewpage.action?pageId=225346196

GCP

	https://console.cloud.google.com/dataflow/jobs?project=clgx-idap-db-services-dev-3e8a

JENKINS

	https://jenkins.solutions.corelogic.com/idap-data-pipelines-us/job/clvtdatapipelines/


GitHub
	
	Enterprise Business System (EBS) Spring Boot Starters
	From <https://github.com/corelogic/ebs-spring-boot-starters> 
	
	IDAP starter with sample application requires kerberos starter
	https://github.com/corelogic/idap-spring-boot-starters/tree/master/idap-kafka-service-starter
	https://github.com/corelogic/idap-spring-boot-starters/tree/master/idap-scs-kerberos-config-starter

	My Corelogic Repo
	https://github.com/corelogic/cloud-mgtx-clct-pipeline

	corelogic/clvtdatapipelines
	From <https://github.com/corelogic/clvtdatapipelines> 
	
	idap-avro-schemas
	From <https://github.com/corelogic/idap-avro-schemas/tree/develop/cloud-mgtx-clct-pipeline/proteus> 
	
	Teams
	https://github.com/orgs/corelogic/teams/cloud-mgtx-clct-pipeline
	

Dockerfile Repository
 
https://github.com/corelogic/clgx-jenkins-dockerfile/tree/master/idap-data-pipelines-us/clvtdatapipelines	<--- 404	


Jenkins URL for Docker image build logs:
	 
https://jenkins.solutions.corelogic.com/platform-services-glb/job/jenkins/job/prd/job/DockerImage/



Artifactory URLs for binary storage:
 
Release:
 
	https://artifactory.solutions.corelogic.com/artifactory/webapp/#/artifacts/browse/tree/General/idap_data_pipelines_us-clvtdatapipeline-generic-release-virtual   <-- 404
 
Snapshot:
 
	https://artifactory.solutions.corelogic.com/artifactory/webapp/#/artifacts/browse/tree/General/idap_data_pipelines_us-clvtdatapipeline-generic-snapshot-virtual	<-- 404


 Kafka
	 
	NOTE:  YOU WILL NEED APPGATE TO ACCESS THE KAFKA CONTROL CENTER
	 
	Topic names: 
	s
	Messages204Files273People10Channels9
	
	From <https://app.slack.com/client/T034AGHJ2/search/search-5246ac99-fa21-4f66-83b9-c451ffccf189> 
	
	tpham-test-1.dev 
	stpham-test-2.dev
	 
	control center: https://prd-kafka-c3-blue-control-1.c3.prd.cloud.clgxdata.com:9021/clusters/
	
	schema-registry-path: 
	https://dev-kafka-blue-registry-1.kafka.dev.cloud.clgxdata.com:8081,https://dev-kafka-blue-registry-2.kafka.dev.cloud.clgxdata.com:8081
	 
	kafka-brokers in dev: 
	dev-kafka-blue-broker-1.kafka.dev.cloud.clgxdata.com:9093,dev-kafka-blue-broker-2.kafka.dev.cloud.clgxdata.com:9093,dev-kafka-blue-broker-3.kafka.dev.cloud.clgxdata.com:9093,dev-kafka-blue-broker-4.kafka.dev.cloud.clgxdata.com:9093,dev-kafka-blue-broker-5.kafka.dev.cloud.clgxdata.com:9093,dev-kafka-blue-broker-6.kafka.dev.cloud.clgxdata.com:9093
	
	 
	Kafka 1.5 Cluster Endpoints: 
	 
	https://confluence.corelogic.net/display/DAT/Cluster+Endpoints
	 
	Sample Client Config: 
	 
	https://confluence.corelogic.net/display/DAT/On-Board+application+to+Kafka+V1.5
	 
	Producer and Consumer Parameter Configuration Information: 
	 
	https://docs.confluent.io/current/installation/configuration/producer-configs.html
	https://docs.confluent.io/current/installation/configuration/consumer-configs.html
	 
	 
	Kafka 1.5 Cluster Endpoints: 
	 
	https://confluence.corelogic.net/display/DAT/Cluster+Endpoints
	 
	Sample Client Config: 
	 
	https://confluence.corelogic.net/display/DAT/On-Board+application+to+Kafka+V1.5
	 
	Producer and Consumer Parameter Configuration Information: 
	 
	https://docs.confluent.io/current/installation/configuration/producer-configs.html
	https://docs.confluent.io/current/installation/configuration/consumer-configs.html
	 
	
	
	
	
VERACODE

	Veracode static scan https://confluence.corelogic.net/display/IDP/How+To+Create+a+Veracode+Static+Scan
	

ELK App Logging

From <https://confluence.corelogic.net/display/IDP/ELK+App+Logging> 


Nexus Jars
https://repo.corelogic.net/nexus/content/repositories/idap-snapshot/com/corelogic/idap/avro/pojos/idap-pipeline-avro-pojos/


Flex Template
https://github.com/corelogic/idap-platform-poc-orchestrator/tree/develop/flex-template


idap-platform-poc-orchestrator

From <https://github.com/corelogic/idap-platform-poc-orchestrator/tree/develop/flex-template> 


README.md
Flex template
	1. Dockerfile
	2. metadata file
	3. gcloud auth login
	4. gcloud auth application-default login
	5. gcloud config set project clgx-idap-poc-de4d
	6. gcloud builds submit --tag "gcr.io/clgx-idap-poc-de4d/dataflow/orchestrator-test-2:latest"
	7. gcloud beta dataflow flex-template build "gs://clgx-scdf-data-dev-stpham/dataflow-poc/tmp/audit/poc/templates/docker-test-11/orchestrator-poc"
--image "gcr.io/clgx-idap-poc-de4d/dataflow/orchestrator-test-2:latest"
--sdk-language "JAVA"
--metadata-file "orchestrator-poc_metadata"
gcloud beta dataflow flex-template run "orchestartor-poc-`date +%Y%m%d-%H%M%S`" \
--template-file-gcs-location "gs://clgx-scdf-data-dev-stpham/dataflow-poc/tmp/audit/poc/templates/docker-test-10/orchestrator-poc" \
--num-workers=1 \
--max-workers=1 \
--project=clgx-scdf-data-dev-d693 \
--region=us-west1 \
--service-account-email=dataflow-service-account@clgx-scdf-data-dev-d693.iam.gserviceaccount.com \
--subnetwork=https://www.googleapis.com/compute/v1/projects/clgx-network-nonprd-4dd3/regions/us-west1/subnetworks/clgx-idap-us-w1-app-dev-subnet \
--parameters outputPath=gs://clgx-scdf-data-dev-stpham/dataflow-poc/tmp/audit/poc/file-formatter-poc-template-run-situs-state-with-compression-and-upload-8/ \
--parameters recordsPerFile=2000000 \
--parameters sizePerFile=2147483648 \
--parameters removeSplitColumn=true \
--parameters includeHeader=false \
--parameters delimiter=COMMA \
--parameters fileFormat=CSV \
--parameters systemFormat=UNIX \
--parameters textQualifier=true \
--parameters splitBy=SITUS_STATE \
--parameters bigQueryProjectName=clgx-idap-poc-de4d \
--parameters bigQueryDataSet=view_ent_property_sandbox \
--parameters bigQueryTableName=property_basic \
--parameters fileNamePattern=situs-state-split \
--parameters numberOfRecordSampleFile=100 \
--parameters cmasProperties=skip \
--parameters compressionType=PZIP \
--parameters destinationFolderInCompressedFile=output \
--parameters password=1234 \
--parameters artifactPerFolder=false \
--parameters jobId=stubIdName \
--parameters ftpHostName=ftp2.resftp.com \
--parameters ftpUserName="{cipher}AQC/87Mc/pjnZPHoac/0BE1nS2FF4t8bSe5mX0OoCM54iyg4wUDeWStWyM6S0M35hd9p5mDayiMur1D18O3+ZdTAOZda6L0bcBp99g9o+eAC7nJI48A2dsywxIIFoqnmMUoCTedFrSv1mVTGW24U/M3eLGtDJ9JwH/3UoON1Fu8UXp4tXWZr6TnVl33/MCdrVLZLIwQkpV3NLrqAUDQ3SDYx5amY1lM4bFX0Q+aSdQGgCPj7uEwUklqUAf/A8Q0XX9ddnPPnn4e7DnYhFP/MimI+HepEjsbkqNZuGNwDi+vuQV3ZFqPcMIBRY8ozc9Cs5aOJe4yMlmnLIpJ6IlWVDQ9SRDiV9ZAEEUamn9C+wJ3RlD3vvZCqjOk7zygt/Q5zgL8=" \
--parameters ftpPassword="{cipher}AQDH2IviGfEdQ5vqOp+X1rFBCsi46BKckGJH31y7PnaM4kobg7hkqOM9e6ezExEIjp19Hs0kDFd8zQVACSqi1HwQukZZMOzH7Wfv3/c6XoVAcHi4VIjpfuYrzxFFg/VfL9BxbzOexu/Qg0tSifNjYAJ0yySABc6k1LdYxyUKOIgOUW+37Uoq4XrJJAm0j/bZocOzYocLO4WKJYvf8M7cKucz5ADdbRRooYYj1e2ubZ6UoPxHYJ0vtx0RO6LjX/g/TNfHlei9/DHbTBJVTsdOn9d0Ic+v8OlMdkq4gx8nOac2OgkIAUYBMsOtsv6mb69UcK/fYZI6KGxqYCqHdfsveL0h9UlMwW5vr5zoY7BfvdNyzPQegidjOsC83hCexUNXIwI=" \
--parameters ftpPort=22 \
--parameters ftpFilePath=/IDAP_BulkDataFulfillment_QA/dev/dataflow-poc/compression-and-ftp/9/ \
--worker-machine-type=n1-standard-2 

From <https://github.com/corelogic/idap-platform-poc-orchestrator/tree/develop/flex-template> 


![image](https://user-images.githubusercontent.com/39197414/113592360-a8b92280-95fa-11eb-81c0-59b7670fe01b.png)

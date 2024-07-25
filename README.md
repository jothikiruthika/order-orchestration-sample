This project is a clone of the [Camunda 8 process solution template](https://github.com/camunda-community-hub/camunda-8-process-solution-template/blob/main/README.md)
Please refer to the Readme in the [Camunda 8 process solution template](https://github.com/camunda-community-hub/camunda-8-process-solution-template/blob/main/README.md) to learn more.

1. The BPMN files for you to try out are part of the resources folder under the main folder. For you to try this on Camunda Saas please do the below -
2. Sign up for a CAmunda 8 trial account at https://signup.camunda.com
3. Once you are able to login to the SaaS modeler, upload the bpmn files under the [resources/models](src/main/resources/models) folder.
4. [Generate the api credentials](https://docs.camunda.io/docs/components/console/manage-clusters/manage-api-clients/#create-a-client) as outlined in the documentation with access to zeebe, tasklist, operate, optimize & tasklist; use these credentails to connect to this camunda trial cluster -> paste them in the application.properties
5. Click on Run and provide the sample JSON data in the [Sample Json](src/main/resources/sampleData.json) file to get a sample process instance running.



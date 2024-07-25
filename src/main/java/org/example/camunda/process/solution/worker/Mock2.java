package org.example.camunda.process.solution.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.model.bpmn.BpmnModelException;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Mock2 {

  private static final Logger LOGGER = LoggerFactory.getLogger(Mock2.class);

  @JobWorker(type = "mock2", autoComplete = false)
  public void mock(final ActivatedJob job) {

    LOGGER.debug("Mock2 Job processed");
    Random random = new Random();
    var result = random.nextBoolean();
    if (result) throw new BpmnModelException("mocked 2 exception");
  }

  //	@ZeebeWorker(type = "send_twilo_sms_received_message", autoComplete = false)
  //	public void sendTwiloSmsReceivedMessage(final ActivatedJob job) {
  //		LinkedHashMap  smsData = (LinkedHashMap)job.getVariablesAsMap().get("sms_data");
  //		String waId = (String)job.getVariablesAsMap().get("waId");
  //		client.newPublishMessageCommand().messageName("twilo_sms_received").correlationKey(waId).
  //				variables(smsData).send().join();
  //		System.out.println("completed : send_twilo_sms_received_message with waId :"+waId);
  //		return;
  //	}
  //
  //	@ZeebeWorker(type = "send_sms_correlated_message", autoComplete = false)
  //	public void sendSmsCorrelatedMessage(final ActivatedJob job) {
  //		String waId = (String)job.getVariablesAsMap().get("WaId");
  //
  //	client.newPublishMessageCommand().messageName("sms_correlated").correlationKey(waId).send().join();
  //		System.out.println("completed : send_sms_correlated_message with waId :"+waId);
  //		return;
  //	}
  //
  ////	@ZeebeWorker(type = "benchmark-task-7", autoComplete = false)
  ////	public void handleMockJob7(final ActivatedJob job) {    }
  ////	@ZeebeWorker(type = "benchmark-task-8", autoComplete = false)
  ////	public void handleMockJob8(final ActivatedJob job) {    }
  ////	@ZeebeWorker(type = "benchmark-task-9", autoComplete = false)
  ////	public void handleMockJob9(final ActivatedJob job) {    }
  ////	@ZeebeWorker(type = "benchmark-task-10", autoComplete = false)
  ////	public void handleMockJob10(final ActivatedJob job) {    }
  ////	@ZeebeWorker(type = "benchmark-task-11", autoComplete = false)
  ////	public void handleMockJob11(final ActivatedJob job) {    }
}

package org.example.camunda.process.solution.worker;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.client.api.worker.JobClient;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Mock {

  private static final Logger LOGGER = LoggerFactory.getLogger(Mock.class);

  @JobWorker(type = "benchmark-task-1", autoComplete = false, timeout = 80000)
  public void mock(final ActivatedJob job, final JobClient client) throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-1 Job with key " + key + "  starting at " + start);
    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-1 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-1 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
    //    Random random = new Random();
    //    var result = random.nextBoolean();
    //    if (result) throw new BpmnModelException("mocked 1 exception");
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
  @JobWorker(type = "benchmark-task-7", autoComplete = false, timeout = 80000)
  public void handleMockJob7(final ActivatedJob job, final JobClient client)
      throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-7 Job with key " + key + "  starting  at " + start);

    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-7 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-7 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
  }

  @JobWorker(type = "benchmark-task-6", autoComplete = false, timeout = 80000)
  public void handleMockJob6(final ActivatedJob job, final JobClient client)
      throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-6 Job with key " + key + "  starting  at " + start);

    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-6 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-6 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
  }

  @JobWorker(type = "benchmark-task-5", autoComplete = false, timeout = 80000)
  public void handleMockJob5(final ActivatedJob job, final JobClient client)
      throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-5 Job with key " + key + "  starting at " + start);
    //    var start = System.currentTimeMillis();
    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-5 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-5 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
  }

  @JobWorker(type = "benchmark-task-4", autoComplete = false, timeout = 80000)
  public void handleMockJob4(final ActivatedJob job, final JobClient client)
      throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-4 Job with key " + key + "  starting at " + start);
    //    var start = System.currentTimeMillis();
    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-4 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-4 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
  }

  @JobWorker(type = "benchmark-task-3", autoComplete = false, timeout = 80000)
  public void handleMockJob3(final ActivatedJob job, final JobClient client)
      throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-3 Job with key " + key + "  starting at " + start);
    //    var start = System.currentTimeMillis();
    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-3 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-3 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
  }

  @JobWorker(type = "benchmark-task-2", autoComplete = false, timeout = 80000)
  public void handleMockJob2(final ActivatedJob job, final JobClient client)
      throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-2 Job with key " + key + "  starting at " + start);
    //    var start = System.currentTimeMillis();
    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-2 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-2 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
  }

  @JobWorker(type = "benchmark-task-8", autoComplete = false, timeout = 80000)
  public void handleMockJob8(final ActivatedJob job, final JobClient client)
      throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-8 Job with key " + key + "  starting at " + start);
    //    var start = System.currentTimeMillis();
    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-8 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-8 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
  }

  @JobWorker(type = "benchmark-task-9", autoComplete = false, timeout = 80000)
  public void handleMockJob9(final ActivatedJob job, final JobClient client)
      throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-9 Job with key " + key + "  starting at " + start);
    //    var start = System.currentTimeMillis();
    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-9 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-9 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
  }

  @JobWorker(type = "benchmark-task-10", autoComplete = false, timeout = 80000)
  public void handleMockJob10(final ActivatedJob job, final JobClient client)
      throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-10 Job with key " + key + "  starting at " + start);
    //    var start = System.currentTimeMillis();
    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-10 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-10 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
  }

  @JobWorker(type = "benchmark-task-11", autoComplete = false, timeout = 80000)
  public void handleMockJob11(final ActivatedJob job, final JobClient client)
      throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-11 Job with key " + key + "  starting at " + start);
    //    var start = System.currentTimeMillis();
    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-11 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-11 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
  }

  @JobWorker(type = "benchmark-task-12", autoComplete = false, timeout = 80000)
  public void handleMockJob12(final ActivatedJob job, final JobClient client)
      throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-12 Job with key " + key + "  starting at " + start);
    //    var start = System.currentTimeMillis();
    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-12 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-12 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
  }

  @JobWorker(type = "benchmark-task-13", autoComplete = false, timeout = 80000)
  public void handleMockJob13(final ActivatedJob job, final JobClient client)
      throws InterruptedException {
    var key = job.getKey();
    var start = System.currentTimeMillis();
    LOGGER.debug("benchmark-task-13 Job with key " + key + "  starting at " + start);
    //    var start = System.currentTimeMillis();
    Thread.sleep(5000);

    client
        .newCompleteCommand(key)
        .send()
        .thenApply(
            completeJobResponse -> {
              LOGGER.debug(
                  "benchmark-task-13 Job with key "
                      + key
                      + " processed Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              return completeJobResponse;
            })
        .exceptionally(
            ex -> {
              LOGGER.debug(
                  "benchmark-task-13 Job with key "
                      + key
                      + " failed-  Duration(ms) :"
                      + (System.currentTimeMillis() - start));
              throw new RuntimeException(ex.getMessage());
            });
  }
}

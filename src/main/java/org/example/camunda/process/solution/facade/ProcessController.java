package org.example.camunda.process.solution.facade;

import io.camunda.zeebe.client.ZeebeClient;
import org.example.camunda.process.solution.ProcessConstants;
import org.example.camunda.process.solution.dto.ProcessVariables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/process")
public class ProcessController {

  private static final Logger LOG = LoggerFactory.getLogger(ProcessController.class);
  private final ZeebeClient zeebe;

  public ProcessController(ZeebeClient client) {
    this.zeebe = client;
  }

  @PostMapping("/start")
  public void startProcessInstance(@RequestBody ProcessVariables variables) {

    LOG.info(
        "Starting process `" + ProcessConstants.BPMN_PROCESS_ID + "` with variables: " + variables);

    zeebe
        .newCreateInstanceCommand()
        .bpmnProcessId(ProcessConstants.BPMN_PROCESS_ID)
        .latestVersion()
        .variables(variables)
        .send();
  }

  @PostMapping("/topo")
  public void getTopology(@RequestBody ProcessVariables variables) {

    LOG.info("Getting Topo");

    LOG.info(zeebe.newTopologyRequest().send().join().toString());
  }

  @PostMapping("/message/{messageName}/{correlationKey}")
  public void publishMessage(
      @PathVariable String messageName,
      @PathVariable String correlationKey,
      @RequestBody ProcessVariables variables) {

    LOG.info(
        "Publishing message `{}` with correlation key `{}` and variables: {}",
        messageName,
        correlationKey,
        variables);

    zeebe
        .newPublishMessageCommand()
        .messageName(messageName)
        .correlationKey(correlationKey)
        .variables(variables)
        .send();
  }
}

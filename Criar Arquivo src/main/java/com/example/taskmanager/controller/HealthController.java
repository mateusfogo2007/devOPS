package com.example.taskmanager.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/health")
public class HealthController {
 @GetMapping
 public Map<String, String> checkHealth() {
 Map<String, String> status = new HashMap<>();
 status.put("status", "UP");
 status.put("service", "Task Manager API");
 return status;
 }
}

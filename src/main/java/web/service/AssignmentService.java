package web.service;

import org.springframework.stereotype.Service;
import web.model.AssignedPair;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssignmentService {

    private final List<AssignedPair> assignedPairs = new ArrayList<>();

    public void addAssignment(String driverName, String carModel) {
        assignedPairs.add(new AssignedPair(driverName, carModel));
    }

    public List<AssignedPair> getAllAssignments() {
        return assignedPairs;
    }
}

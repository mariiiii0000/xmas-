package Models;


import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask> subtasks = new ArrayList<>();


    public Epic( String name, String description) {
        super( name, description, "NEW");
    }
    public Epic( String name, String description, long ID) {
        super( name, description, "NEW");
        this.ID = ID;
    }


    public void addSubtasks(Subtask subtask){
        subtasks.add(subtask);
        updateSubtasksStatus();
    }



    public void updateSubtasksStatus(){
        for (Subtask subtask: subtasks){
            if ((subtask.getStatus().equals("NEW") && status.equals("DONE"))) {
                status = "IN PROCESS";
            } else if (subtask.getStatus().equals("NEW") && status.equals("IN PROCESS")){
                status = "IN PROCESS";
            }
            if ((subtask.getStatus().equals("IN PROCESS")) && status.equals("NEW")) {
                status = "IN PROCESS";
            }
            if (subtask.getStatus().equals("IN PROCESS") && status.equals("DONE")) {
                status = "IN PROCESS";
            }
            if (subtask.getStatus().equals("IN PROCESS") && status.equals("IN PROCESS")) {
                status = "IN PROCESS";
            }
            if (subtask.getStatus().equals("DONE") && status.equals("IN PROCESS")) {
                status = "IN PROCESS";
            }
            if (subtask.getStatus().equals("NEW") && status.equals("NEW")) {
                status = "NEW";
            }
            if (subtask.getStatus().equals("DONE") && status.equals("DONE")) {
                status = "DONE";
            }
            if (subtask.getStatus().equals("DONE") && status.equals("NEW")) {
                status = "IN PROCESS";
            }


        }

    }
    public  void removeSubtasks(){
        subtasks.clear();
        status = "new";
    }


    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subtasks=" + subtasks +
                ", status='" + status + '\'' +
                ", ID=" + ID +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

package Manager;

import Models.Epic;
import Models.Subtask;
import Models.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class Manager {


    private HashMap<Long,Task> taskHashMap = new HashMap<>();
    private HashMap<Long, Subtask> subtaskHashMap = new HashMap<>();
    private HashMap<Long, Epic> epicHashMap = new HashMap<>();
    private long nextID = 1;



    public Task getTaskByID(long id){
        return taskHashMap.get(id);
    }
    public Subtask getSubtaskByID(long id){
        return subtaskHashMap.get(id);
    }
    public Epic getEpicByID(long id){
        return epicHashMap.get(id);
    }


    public void removeAllSubtasks(){
        subtaskHashMap.clear();
        for (Epic epic: epicHashMap.values()){
            epic.removeSubtasks();
        }
    }




    public void removeTasksByID(long id){
        taskHashMap.remove(id);
    }
    public void removeSubtaskByID(long id){
        subtaskHashMap.remove(id);
    }
    public void removeEpicByID(long id){
        epicHashMap.remove(id);
    }




    public ArrayList<Subtask> getSubtasks(){
        return new ArrayList<>(subtaskHashMap.values());
    }

    public ArrayList<Epic> getEpics(){
        return new ArrayList<>(epicHashMap.values());
    }

    public ArrayList<Task> getTasks(){
        return new ArrayList<>(taskHashMap.values());

    }



    public void removeEpics(){
        epicHashMap.clear();
    }
    public void removeSubtask(){
        subtaskHashMap.clear();
    }
    public void removeTasks(){
        taskHashMap.clear();
    }



    public void updateTask(Task newTask){
        taskHashMap.remove(newTask.getID(), newTask);
        taskHashMap.put(newTask.getID(), newTask);
    }

    public void updateSubtask(Subtask newSubtask){
        subtaskHashMap.put(newSubtask.getID(), newSubtask);
    }

    public void updateEpic(Epic newEpic){
        epicHashMap.put(newEpic.getID(), newEpic);
    }




    public ArrayList<Subtask> getSubtasksByEpicID(long id){
        Epic epic = getEpicByID(id);
        return epic.getSubtasks();
    }



    public void createTask(Task task){
        task.setID(nextID);
        taskHashMap.put(task.getID(), task);
        nextID++;
    }

    public void createSubtask(Subtask subtask){
        long epicID = subtask.getEpicID();
        if (!epicHashMap.containsKey(epicID)){
            System.out.println("Не найден ID((((");
            return;
        }
        Epic epic = epicHashMap.get(epicID);
        subtask.setID(nextID);
        epic.addSubtasks(subtask);
        subtaskHashMap.put(subtask.getID(), subtask);
        nextID++;
    }

    public void createEpic(Epic epic) {
        epic.setID(nextID);
        nextID++;
        epicHashMap.put(epic.getID(), epic);

    }

}

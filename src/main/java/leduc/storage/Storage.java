package leduc.storage;

import leduc.Date;
import leduc.command.*;
import leduc.exception.FileException;
import leduc.exception.MeaninglessException;
import leduc.exception.NonExistentDateException;
import leduc.task.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Represents a leduc.storage.Storage which deals with loading tasks from the file and saving tasks in the file.
 */
public class Storage {
    private File file;
    private File configFile;
    private File welcomeFile;
    private String language;

    /**
     * Constructor of leduc.storage.Storage
     * @param file String representing the path of the file
     * @param configFile String representing the path of the file storing the shortcut
     * @throws FileException  Exception caught when the file can't be open or read or modify.
     * @throws MeaninglessException Exception caught when the input string could not be interpreted.
     * @throws NonExistentDateException Exception caught when the date given does not exist.
     */
    public Storage(String file, String configFile, String welcomeFile) throws FileException, MeaninglessException, NonExistentDateException {
        this.file = new File(file);
        try {
            this.file.createNewFile();
        } catch (IOException e) {
            //  Case of a jar execution : create or use the duke.txt file in the current path
            this.file = new File ("duke.txt");
            try{
                this.file.createNewFile();
            }
            catch( IOException e1){
                e1.printStackTrace();
            }
            // Create initialized tasks in the new file
            TaskList taskList = new TaskList(new ArrayList<>());
            LocalDateTime d1 = null;
            LocalDateTime d2 = null;
            Date date1 = null;
            Date date2 = null;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.ENGLISH);

            try{
                d1 = LocalDateTime.parse("15/11/2019 22:33".trim(), formatter);
            }catch(Exception exception){
                    throw new NonExistentDateException();
            }
            date1 = new Date(d1);
            taskList.add(new HomeworkTask("math assignment 1",date1,1));

            try{
                d1 = LocalDateTime.parse("15/11/2019 23:59".trim(), formatter);
            }catch(Exception exception){
                throw new NonExistentDateException();
            }
            date1 = new Date(d1);
            taskList.add(new HomeworkTask("science",date1,1));
            taskList.add(new HomeworkTask("science 2","[V]",date1));

            try{
                d1 = LocalDateTime.parse("21/11/2019 00:00".trim(), formatter);
                d2 = LocalDateTime.parse("28/11/2019 22:22".trim(), formatter);
            }catch(Exception exception){
                throw new NonExistentDateException();
            }
            date1 = new Date(d1);
            date2 = new Date(d2);
            taskList.add(new EventsTask("Sport","[X]",date1,date2));
            taskList.add(new HomeworkTask("CS4239: lab3","[V]",date1));
            taskList.add(new HomeworkTask("CS4239: lab4","[X]",date1));

            try{
                d1 = LocalDateTime.parse("18/09/2019 12:12".trim(), formatter);
            }catch(Exception exception){
                throw new NonExistentDateException();
            }
            date1 = new Date(d1);
            taskList.add(new HomeworkTask("CS2113: revision exercice",date1,2));

            try{
                d1 = LocalDateTime.parse("21/12/2019 00:00".trim(), formatter);
                d2 = LocalDateTime.parse("28/12/2019 13:22".trim(), formatter);
            }catch(Exception exception){
                throw new NonExistentDateException();
            }
            date1 = new Date(d1);
            date2 = new Date(d2);
            taskList.add(new EventsTask("Badminton","[X]",date1,date2));
            taskList.add(new HomeworkTask("CS4239: lab5","[V]",date1));
            taskList.add(new HomeworkTask("CS4239: lab6","[X]",date1));

            try{
                d1 = LocalDateTime.parse("18/11/2019 12:00".trim(), formatter);
                d2 = LocalDateTime.parse("18/11/2019 13:22".trim(), formatter);
            }catch(Exception exception){
                throw new NonExistentDateException();
            }
            date1 = new Date(d1);
            date2 = new Date(d2);
            taskList.add(new EventsTask("Football","[X]",date1,date2));
            taskList.add(new HomeworkTask("CS2111: lab5","[V]",date1));
            taskList.add(new HomeworkTask("CS1212: lab6","[X]",date1));

            taskList.add(new TodoTask("td3",3));
            taskList.add(new TodoTask("td4",4));
            taskList.add(new TodoTask("cs2113",4));
            taskList.add(new TodoTask("cs4239","[V]"));
            taskList.add(new TodoTask("UG",5));
            taskList.add(new TodoTask("DG",6));
            taskList.add(new TodoTask("homework CS2131",7));
            taskList.add(new TodoTask("read a book",8));
            taskList.add(new TodoTask("sell book",9));
            taskList.add(new TodoTask("Exercice 1",8));
            taskList.add(new TodoTask("Preparation final exam",7));
            taskList.add(new TodoTask("Exercice 2",6));
            taskList.add(new TodoTask("test before final exam",5));
            taskList.add(new TodoTask("Software security: lab 4: exercice 2",8));
            taskList.add(new TodoTask("Software security: lab 5: exercice 1",7));
            taskList.add(new TodoTask("Software security: lab 6: exercice 1",6));
            taskList.add(new TodoTask("Software security: lab 6: exercice 2",5));
            this.save(taskList.getList());
        }
        this.configFile = new File(configFile);
        try {
            if(this.configFile.createNewFile()){ //if file exist, return false
                this.language = "en";
                saveConfig();
            }
            else {
                loadConfig();
            }
        } catch (IOException e) {
            //  Case of a jar execution : create or use the config.txt file in the current path
            this.configFile = new File ("config.txt");
            try{
                if(this.configFile.createNewFile()){ //if file exist, return false
                    this.language = "en";
                    saveConfig();
                }
                else {
                    loadConfig();
                }
            }
            catch( IOException e1){
                e1.printStackTrace();
            }
        }
        this.welcomeFile = new File(welcomeFile);
        try {
            this.welcomeFile.createNewFile();
        } catch (IOException e) {
            // Case of a jar execution : create or use the welcome.txt file in the current path
            this.welcomeFile = new File ("welcome.txt");
            try{
                this.welcomeFile.createNewFile();
            }
            catch( IOException e1){
                e1.printStackTrace();
            }
            // Create initialized welcome message in the new file
            FileWriter fileWriter = null;
            String welcomeMessage ="\tHello I'm Duke\n\tWhat can I do for you ?";
            try {
                fileWriter = new FileWriter(this.welcomeFile);
                try {
                    //removes the first word of the user input
                    fileWriter.write(welcomeMessage);
                }
                finally{
                    fileWriter.close();
                }
            }
            catch (IOException exception) {
                exception.printStackTrace();
                throw new FileException();
            }
        }
    }

    /**
     * Getter of welcome File
     * @return the welcome File
     */
    public File getWelcomeFile(){
        return this.welcomeFile;
    }

    /**
     * read the file and write all the task to an array of task.
     * if the file is empty, the array is empty too
     * @return an array of task
     * @throws FileException thrown when there is a reading error of the file
     */
    public List<Task> load() throws FileException { // load the initial data file
        Scanner sc = null;
        try {
            sc = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileException();
        }
        ArrayList<Task> tasks = new ArrayList<>();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] tokens = line.split("//");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm", Locale.ENGLISH);
            int priority = -1 ;
            switch (tokens[0]){
                case "T" :
                    if (tokens.length ==3 ){ // priority not specified
                        tasks.add(new TodoTask(tokens[2],tokens[1].trim()));
                    }
                    else {
                        priority =  Integer.parseInt(tokens[3].trim());
                        if (priority < 1 || priority > 9) { // the priority is set by default to 5
                            tasks.add(new TodoTask(tokens[2], tokens[1].trim()));
                        }
                        else {
                            tasks.add(new TodoTask(tokens[2], tokens[1].trim(),priority));
                        }
                    }
                    break;
                case "H" :
                    if (tokens.length ==4 ){ // priority not specified
                        tasks.add(new HomeworkTask(tokens[2],tokens[1].trim(), new Date(LocalDateTime.parse(tokens[3], formatter))));
                    }
                    else {
                        priority =  Integer.parseInt(tokens[4].trim());
                        if (priority < 1 || priority > 9) { // the priority is set by default to 5
                            tasks.add(new HomeworkTask(tokens[2],tokens[1].trim(), new Date(LocalDateTime.parse(tokens[3], formatter))));
                        }
                        else {
                            tasks.add(new HomeworkTask(tokens[2],tokens[1].trim(), new Date(LocalDateTime.parse(tokens[3], formatter)),priority));
                        }
                    }
                    break;
                case "E":
                    if (tokens.length ==5 ){ // priority not specified
                        tasks.add(new EventsTask(tokens[2], tokens[1].trim(), new Date(LocalDateTime.parse(tokens[3], formatter)), new Date(LocalDateTime.parse(tokens[4], formatter))));
                    }
                    else {
                        priority =  Integer.parseInt(tokens[5].trim());
                        if (priority < 1 || priority > 9) { // the priority is set by default to 5
                            tasks.add(new EventsTask(tokens[2], tokens[1].trim(), new Date(LocalDateTime.parse(tokens[3], formatter)), new Date(LocalDateTime.parse(tokens[4], formatter))));
                        }
                        else {
                            tasks.add(new EventsTask(tokens[2], tokens[1].trim(), new Date(LocalDateTime.parse(tokens[3], formatter)), new Date(LocalDateTime.parse(tokens[4], formatter)),priority));
                        }
                    }
                    break;
            }
        }
        return tasks;
    }

    /**
     * write all task to the files
     * @param tasks all the tasks that have to be written to the file
     * @throws FileException thrown when there is writing problem to the files
     */
    public void save(ArrayList<Task> tasks) throws FileException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(this.file);
            try {

                for (Task task : tasks){
                    if (task.isTodo()) {
                        fileWriter.write("T//"+ task.getMark() +"//" + task.getTask() + "//" + task.getPriority() + "\n");
                    } else if (task.isHomework()) {
                        fileWriter.write("H//"+ task.getMark() +"//" + task.getTask() + "//" + ((HomeworkTask) task).getDeadlines().toString()+ "//" + task.getPriority() +"\n");
                    } else if (task.isEvent()) {
                        fileWriter.write("E//"+ task.getMark() +"//" + task.getTask() + "//" + ((EventsTask) task).getDateFirst().toString() + "//" + ((EventsTask) task).getDateSecond().toString() + "//" + task.getPriority() + "\n");
                    }
                }
            } finally {
                fileWriter.close();
            }
        }
        catch(IOException e){
            e.printStackTrace();
            throw new FileException();
        }
    }

    /**
     * Save the configuration (shortcut and language) to a file named config
     * @throws FileException throw when the files can't be read or written
     */
    public void saveConfig() throws FileException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(this.configFile);
            try{
                fileWriter.write("lang:" + this.language + "\n");
                fileWriter.write("bye:" + ByeCommand.getByeShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(ByeCommand.getByeShortcut());
                fileWriter.write("list:" + ListCommand.getListShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(ListCommand.getListShortcut());
                fileWriter.write("help:" + HelpCommand.getHelpShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(HelpCommand.getHelpShortcut());
                fileWriter.write("done:" + DoneCommand.getDoneShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(DoneCommand.getDoneShortcut());
                fileWriter.write("find:" + FindCommand.getFindShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(FindCommand.getFindShortcut());
                fileWriter.write("delete:" + DeleteCommand.getDeleteShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(DeleteCommand.getDeleteShortcut());
                fileWriter.write("homework:" + HomeworkCommand.getHomeworkShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(HomeworkCommand.getHomeworkShortcut());
                fileWriter.write("event:" + EventCommand.getEventShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(EventCommand.getEventShortcut());
                fileWriter.write("todo:" + TodoCommand.getTodoShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(TodoCommand.getTodoShortcut());
                fileWriter.write("edit:" + EditCommand.getEditShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(EditCommand.getEditShortcut());
                fileWriter.write("postpone:" + PostponeCommand.getPostponeShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(PostponeCommand.getPostponeShortcut());
                fileWriter.write("snooze:" + SnoozeCommand.getSnoozeShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(SnoozeCommand.getSnoozeShortcut());
                fileWriter.write("reschedule:" + RescheduleCommand.getRescheduleShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(RescheduleCommand.getRescheduleShortcut());
                fileWriter.write("remind:" + RemindCommand.getRemindShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(RemindCommand.getRemindShortcut());
                fileWriter.write("sort:" + SortCommand.getSortShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(SortCommand.getSortShortcut());
                fileWriter.write("setwelcome:" + SetWelcomeCommand.getSetWelcomeShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(SetWelcomeCommand.getSetWelcomeShortcut());
                fileWriter.write("prioritize:" + PrioritizeCommand.getPrioritizeShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(PrioritizeCommand.getPrioritizeShortcut());
                fileWriter.write("unfinished:" + UnfinishedCommand.getUnfinishedShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(UnfinishedCommand.getUnfinishedShortcut());
                fileWriter.write("language:" + LanguageCommand.getLanguageShortcut() + "\n");
                ShortcutCommand.getSetShortcut().add(LanguageCommand.getLanguageShortcut());
            }finally {
                fileWriter.close();
            }
        }catch(IOException e){
            e.printStackTrace();
            throw new FileException();
        }
    }

    /**
     * Load the config file and setup the language and the shortcuts
     * @throws FileException throw when the file can't be read or written
     * @throws MeaninglessException throw when the command name is unknown
     */
    public void loadConfig() throws FileException, MeaninglessException {
        Scanner sc = null;
        try {
            sc = new Scanner(this.configFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileException();
        }
        if(sc.hasNext()){
            String languageString = sc.nextLine();
            String[] languageStringSplit = languageString.split(":");
            if(languageStringSplit.length == 2 && languageStringSplit[0].equals("lang")){
                this.language = languageStringSplit[1];
                if(!(this.language.equals("en") || this.language.equals("fr"))){
                    this.language = "en";
                }
            }
            else{
                this.language = "en";
            }
        }
        while(sc.hasNext()){
            String commandShortcut = sc.nextLine();
            String[] commandShortcutSplit = commandShortcut.split(":");
            if(commandShortcutSplit.length == 2){
                ShortcutCommand.setOneShortcut(commandShortcutSplit[0].trim(), commandShortcutSplit[1].trim());
            }
        }

    }

    public void setLanguage(String language){
        this.language = language;
    }
    public String getLanguage(){
        return this.language;
    }
}

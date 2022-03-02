package org.testapp.Ui.Pages.Faveo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testapp.Ui.Pages.BasePage;

public class NewTicketPage extends BasePage {

    private By emailLocator = By.id("email");
    private By firstNameLocator = By.id("first_name");
    private By lastNameLocator = By.id("last_name");
    private By countryCodeLocator = By.id("country_code");
    private By mobileLocator = By.id("mobile");
    private By phoneLocator = By.id("phone_number");

    private By subjectTextAreaLocator = By.cssSelector("input[name='subject']");
    private By detailTextAreaLocator = By.cssSelector("div[role='textbox']");

    private By createTicketButtonLocator = By.cssSelector("input[value='Create ticket']");

    public By departmentDropdown = By.xpath("/html/body/div[1]/div[1]/section/div/form/div/div[2]/div[2]/div[2]/div/div[1]/div[3]/div/select");
    Select departmentSelect;

    public By helpTopicDropDown = By.cssSelector("#help_topic_id");
    Select helpTopicSelect;

    //public By statusDropDown = By.cssSelector("#status_id");
    public By statusDropDown = By.cssSelector("select[name='status']");

    Select statusSelect;

    public By slaDropDown = By.id("sla_plan_id");
    Select slaPlanSelect;

    public By assignToDropDown = By.id("agent_id");
    Select assignToAgentSelect;

    public By locationDropDown = By.id("location_id");
    Select locationSelect;

    public By ticketTypeDropDown = By.id("ticket_type_id");
    Select ticketTypeSelect;

    public By priorityDropDown = By.id("priority_id");
    Select prioritySelect;






    public NewTicketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void getTicketCreate(){
        driver.get(APP_URL.concat("/newticket"));
    }

    public void selectPriority(String priority){
        prioritySelect = new Select(findBy(priorityDropDown));

        if(priority.equalsIgnoreCase("low")){
            prioritySelect.selectByIndex(0);
        }else if (priority.equalsIgnoreCase("normal")){
            prioritySelect.selectByIndex(1);
        }else if (priority.equalsIgnoreCase("high")){
            prioritySelect.selectByIndex(2);
        }else if(priority.equalsIgnoreCase("critical")){
            prioritySelect.selectByIndex(3);
        }
    }



    public void selectTicketType(String ticketType){
        ticketTypeSelect = new Select(findBy(ticketTypeDropDown));

        if (ticketType.equalsIgnoreCase("test type")){
            ticketTypeSelect.selectByIndex(0);
        }else{
            ticketTypeSelect.selectByValue("1");
        }
    }




    public void selectLocation(String locationName){
        locationSelect = new Select(findBy(locationDropDown));

        if (locationName.equalsIgnoreCase("testbug")){
            locationSelect.selectByIndex(0);
        }else{
            locationSelect.selectByIndex(0);
        }
    }


    public void selectAssignToAgent(String agentMail){
        assignToAgentSelect = new Select(findBy(assignToDropDown));

        if (agentMail.equalsIgnoreCase("demo admin")){
            assignToAgentSelect.selectByIndex(0);
        }else{
            System.out.println("No available agent name");
        }
    }



    public void selectSlaPlan(String slaPlan){
        slaPlanSelect = new Select(findBy(slaDropDown));

        if (slaPlan.equalsIgnoreCase("6 hours")){
            slaPlanSelect.selectByIndex(0);
        }else if (slaPlan.equalsIgnoreCase("12 hours")){
            slaPlanSelect.selectByIndex(1);
        }else if(slaPlan.equalsIgnoreCase("24 hours")){
            slaPlanSelect.selectByIndex(2);
        }
    }

    public void selectHelpTopic(String helpTopicName) {
        helpTopicSelect = new Select(findBy(helpTopicDropDown));

        if (helpTopicName.equalsIgnoreCase("support query")){
            helpTopicSelect.selectByIndex(0);
        }else{
            helpTopicSelect.selectByValue("1");
        }
    }

    public void selectStatus(String statusName){
        if(statusName.equalsIgnoreCase("open")){
            statusSelect = new Select(findBy(statusDropDown));
            statusSelect.selectByIndex(0);
        }else if(statusName.equalsIgnoreCase("resolved")){
            statusSelect = new Select(findBy(statusDropDown));
            statusSelect.selectByIndex(1);
        }
    }
    public void selectDep2(int value){
        select(departmentDropdown, value);
    }


    public void selectDepartment(String departmentName){
        if (departmentName.equalsIgnoreCase("support")){
            departmentSelect = new Select(findBy(departmentDropdown));
            departmentSelect.selectByIndex(1);
        }else if(departmentName.equalsIgnoreCase("sales")){
            departmentSelect = new Select(findBy(departmentDropdown));
            departmentSelect.selectByIndex(2);
        }else if(departmentName.equalsIgnoreCase("maintenance")){
            departmentSelect = new Select(findBy(departmentDropdown));
            departmentSelect.selectByIndex(3);
        }
    }

    public void fillUserDetails(String email, String firstName, String lastName, String code, String mobileNumber, String phone){
        setText(emailLocator, email);
        setText(firstNameLocator, firstName);
        setText(lastNameLocator, lastName);
        setText(countryCodeLocator, code);
        setText(mobileLocator, mobileNumber);
        setText(phoneLocator, phone);
    }
    public void fillTicketDetail(String subject, String detail){
        setText(subjectTextAreaLocator, subject);
        setText(detailTextAreaLocator, detail);
    }
    public void createTicket(){
        click(createTicketButtonLocator);
    }



}

package com.qa.index;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
	
	public final String URL = "http://127.0.0.1:5500/FrontEnd/index.html";
	
	@FindBy(id = "task-value")
	private WebElement createTask;
	
	@FindBy(id = "create-button")
	private WebElement createBtn;
	
	@FindBy(id = "edit-task")
	private WebElement editBtn;
	
	@FindBy(id = "update-button")
	private WebElement updateBtn;
	
	@FindBy(id = "delete-task")
	private WebElement deleteBtn;
	
	@FindBy(id = "task-title")
	private WebElement taskTitle;
	
	@FindBy(xpath = "/html/body/section/div/div[2]")
	private WebElement cardDiv;
	
	public void create(String task) {
		createTask.sendKeys(task);
		createBtn.click();
	}
	
	public void update(String task) {
		editBtn.click();
		createTask.clear();
		createTask.sendKeys(task);
		updateBtn.click();
	}
	
	public void delete() {
		deleteBtn.click();
	}
	
	public String checkTask() {
		return taskTitle.getText();
	}

}

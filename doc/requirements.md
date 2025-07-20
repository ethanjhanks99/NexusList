# Introduction

## Overview of NexusList

NexusList is the last todo list app users will ever need. Users will be able to create, read, update, and delete tasks, set priority levels for tasks, and even create joint lists with friends and family.

## Purpose of this Document

This document outlines the necessary features, functionalities, and non-functional aspects required to develop the drink ordering app. It serves as a guide for understanding user needs to create a valuable, user-friendly solution.

# Requirements

## 1. Functional Requirements

### Login/Sign-up

* **User Authentication and Authorization**: The application will support user registration and login functionalities, ensuring secuere access to the platform. Users must create accounts using either email and password credentials or third-party OAuth providers for streamlined access.
* **Password Management and Security**: Secure password hashing will be implemented for all passwords. Hashing will be done on the server side. Forgot password functionality will allow users to reset their passwords via verified email.
* **Error Handling**: If registration or login encounters an error, the user will receive details as to why the error occurred. If the user provided incorrect credentials, the user will be permitted to try again. If the user fails to provide correct credentials after a certain number of attempts, their account will be locked.

### Task Features

* **Task Creation**: Users will be able to create tasks that are stored in a persistent database. New tasks will always start with a completion status of incomplete.  They will be able to fill out the following:
  * Task name
  * Task description
  * Task due date
  * Task priority level
  * Task tags
  * Task folder
* **Task Reading**: Users will be able to view all tasks that are associated with their account. Tasks will be layed out in ways that make sense. Users will be able to filter through their tasks by folders, tags, due dates, and priority levels. Users will be able to sort task by due date or priority.
* **Task Updating**: Users will be able to edit tasks that they have made. The following are updatable fields:
  * Title
  * Description
  * Due date
  * Tags
  * Folders
  * Priority lagel
  * Completion status

When a task is marked complete the task becomes invisible to all folders and is added to the `completed` folder. When a user marks a completed task as incomplete, it is removed from the `completed` folder, and is once again visible to the other folders.
* **Task Deletion**: Users will be able to delete tasks. When a task is deleted, it is put in the trash, where it can either be retrievable for up to 30 days, or deleted permenently from the database. If the latter option is taken, it cannot be undone.

### Folders

* **Folder Creation**: Users will be able to create folders that are stored in a persistent database. Folders are always empty when first created. Folders can be initialized with the following data:
  * Name
  * Description
* **Folder Reading**: Users will be able to view all folders that are associated with their account. When a folder is being viewed, the user will be able to see all tasks held by the folder.
* **Folder Updating**: Users will be able to update their folders. This includes changing the folder's name and description. Users will be able to add/remove tasks to/from their folders.
* **Folder Deletion**: Users will be able to delete folders they have created. When a folder is deleted it is moved to the trash. Users will have 30 days to either recover or permenently delete it before it is automatically deleted from the database. Once this happens it cannot be undone. Any tasks held within a deleted folder will also be deleted unless it is held in another folder. Tags do not count towards this.

### Tags

* **Tag Creation**: Users can create tags to label tasks. Created tags will be stored in a persistent database. When creating a tag, users will give the tag a name and a color.
* **Tag reading**: Users will be able to filter tasks by their tags. Users will be able to see a task's tags regardless of what view is being used. 
* **Tag Updating**: Users will be able to update a tag's name and color.
* **Tag Deletion**: Users will be able to delete a tag. When a tag is deleted it is removed from all tasks that have the tag. Tasks do not get deleted by this operation.

## 2. Non-Functional Requirements

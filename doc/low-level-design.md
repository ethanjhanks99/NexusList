# Low Level Design

# Backend

## Entities

Entities are essentially the database table templates. There will be one for every table needed, and they will need to specify the fields and types, as well as provide getters and setters. Entities are annotated with `@Entity`.

### Task

The task entity is the core of the application. There is no NexusList without tasks. Each task object will need the following:

* id
  * Type: Long
  * Description: Key identifier of specific tasks put into the table
  * Required: yes
* user
  * Type: User
  * Description: Ties the task to the user that created it
  * Required: yes
* list
  * Type: TaskList
  * Description: Ties the task to a list
  * Required: yes
* name
  * Type: String
  * Description: Name of the task
  * Required: yes
* description
  * Type: String
  * Description: A short note that describes or holds any additional information for the task
  * Required: no
* priority
  * Type: Priority
  * Description: Marks the importance of the task
  * Required: no
* dueDate
  * Type: LocalDateTime
  * Description: Provides a specific time the task should be done by
  * Required: no
* tags
  * Type: List<Tag>
  * Description: A list of different categories assigned to the task
  * Required: yes
* completed
  * Type: Boolean
  * Description: Marks the completion status of the task
  * Required: yes

When a task is created, the frontend will need to provide the userId, the task name, and the listId. The frontend can provide the description, priority, duedate, and the tags. The id will be automatically generated, and the completion status is always marked as incomplete on default.



📌 Community Donation Campaign & Donor Pledge Tracking System
Hibernate ORM Based Console Application
📖 Overview

This project is a console-based Java application built using Hibernate ORM for managing community donation campaigns and donor pledge tracking.

The system allows a non-profit organization to:

Manage donors

Create and control campaigns

Record pledges

Track payments

Close campaigns safely

Prevent unsafe donor deletion

Hibernate is used for object-relational mapping, entity relationships, and transaction management.

🛠️ Tech Stack

Java

Hibernate ORM

JPA Annotations

Oracle Database

Maven

🏗️ Project Structure
Community-Donation-Hibernate/
│
├── src/main/java
│   │
│   └── com/donate
│        │
│        ├── app
│        │     └── DonateMain.java
│        │
│        ├── entity
│        │     ├── Donor.java
│        │     ├── Campaign.java
│        │     └── Pledge.java
│        │
│        ├── dao
│        │     ├── DonorDAO.java
│        │     ├── CampaignDAO.java
│        │     └── PledgeDAO.java
│        │
│        ├── service
│        │     └── DonateService.java
│        │
│        └── util
│              └── HibernateUtil.java
│
├── src/main/resources
│     └── hibernate.cfg.xml
│
└── pom.xml
🗃️ Database Tables
1️⃣ DONOR_TBL

Stores donor information:

Donor ID (Primary Key)

Full Name

Email

Mobile

City

Status (ACTIVE / INACTIVE)

2️⃣ CAMPAIGN_TBL

Stores campaign details:

Campaign ID (Primary Key)

Campaign Name

Start Date

End Date

Target Amount

Status (PLANNED / ACTIVE / CLOSED)

3️⃣ PLEDGE_TBL

Stores pledge and payment tracking:

Pledge ID (Primary Key, Sequence Generated)

Donor Reference (Foreign Key)

Campaign Reference (Foreign Key)

Pledge Date

Pledge Amount

Amount Paid

Payment Status

Writeoff Flag

🔄 Core Functionalities

✅ Register Donor

Validates required fields

Saves donor with ACTIVE status

✅ Create Campaign

Validates dates and target amount

Saves campaign with defined status

✅ Record Pledge

Checks donor existence

Checks campaign status

Creates pledge with NOT_PAID status

Managed inside Hibernate transaction

✅ Record Payment

Updates amount paid

Automatically updates payment status

Prevents overpayment

✅ Close Campaign

Ensures no unpaid pledges exist

Updates campaign status to CLOSED

✅ Remove Donor

Prevents deletion if active pledges exist

Deletes only when safe

🔐 Hibernate Features Used

Entity Mapping

@OneToMany and @ManyToOne Relationships

Sequence Generation

Session & Transaction Management

HQL Queries

Cascade Operations

Custom Business Validation

▶️ Setup Instructions

Install Oracle Database

Create required tables and sequence

Update database credentials in hibernate.cfg.xml

Build project using Maven

Run DonateMain.java

Use console menu to perform operations

🎯 Learning Outcomes

ORM-based development using Hibernate

Entity relationship mapping

Transaction management

Clean layered architecture

Business rule validation

Console application design

🚀 Future Enhancements

Spring Boot Integration

REST API Version

Web UI

Reporting Dashboard

Authentication & Role Management

Output:
<img width="1889" height="767" alt="image" src="https://github.com/user-attachments/assets/2986b58c-9c32-4f38-9026-28ab00cc5c80" />


👩‍💻 Author

Your Manasha

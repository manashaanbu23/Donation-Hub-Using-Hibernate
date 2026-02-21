📌 Donation Hub Using Hibernate
Community Donation Campaign & Pledge Tracking System
📖 Overview

Donation Hub is a console-based Java application built using Hibernate ORM to manage donation campaigns, donors, pledges, and payments.

This system is designed for non-profit organizations to efficiently track fundraising activities with proper validation and transaction control.

🚀 Features

👤 Register and manage donors

📢 Create and manage campaigns

💰 Record donor pledges

💳 Track payments against pledges

🔒 Close campaigns safely

🛑 Prevent unsafe donor deletion

🛠️ Tech Stack

☕ Java

🗄️ Hibernate ORM

📘 JPA Annotations

🛢️ Oracle Database

## 🏗️ Project Structure

```
Donation-Hub-Using-Hibernate/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── donate/
│       │           ├── app/
│       │           │   └── DonateMain.java
│       │           │
│       │           ├── entity/
│       │           │   ├── Donor.java
│       │           │   ├── Campaign.java
│       │           │   └── Pledge.java
│       │           │
│       │           ├── dao/
│       │           │   ├── DonorDAO.java
│       │           │   ├── CampaignDAO.java
│       │           │   └── PledgeDAO.java
│       │           │
│       │           ├── service/
│       │           │   └── DonateService.java
│       │           │
│       │           └── util/
│       │               └── HibernateUtil.java
│       │
│       └── resources/
│           └── hibernate.cfg.xml
│
├── Query.txt
├── pom.xml
└── README.md
```

🗃️ Database Design

🔹 DONOR_TBL

Stores donor details:

Donor ID (Primary Key)

Full Name

Email

Mobile

City

Status (ACTIVE / INACTIVE)

🔹 CAMPAIGN_TBL

Stores campaign information:

Campaign ID (Primary Key)

Campaign Name

Start Date

End Date

Target Amount

Status (PLANNED / ACTIVE / CLOSED)

🔹 PLEDGE_TBL

Stores pledge & payment tracking:

Pledge ID (Sequence Generated)

Donor Reference

Campaign Reference

Pledge Date

Pledge Amount

Amount Paid

Payment Status

Writeoff Flag

🔐 Hibernate Concepts Used

Entity Mapping

One-to-Many Relationship

Many-to-One Relationship

Sequence Generation

Hibernate Session

Transaction Management

HQL Queries

Cascade Operations

▶️ How to Run

Install Oracle Database

Create required tables and sequence

Update DB credentials in hibernate.cfg.xml

Build project using Maven

Run DonateMain.java

Use the console menu

🎯 Learning Outcomes

ORM-based development using Hibernate

Clean layered architecture

Transaction handling

Business rule validation

Console-based system design

🔮 Future Enhancements

Spring Boot integration

REST API version

Web-based UI

Reporting dashboard

Authentication & authorization

output:

<img width="1919" height="736" alt="image" src="https://github.com/user-attachments/assets/f85ef74a-1cdb-4e55-b4cb-f0b9beae65b4" />

👩‍💻 Author

Manasha 

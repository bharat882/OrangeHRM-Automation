# 🧪 OrangeHRM Web Automation Framework

A modular Selenium + TestNG + Maven + Allure + Jenkins automation framework designed to validate core OrangeHRM workflows such as **Login**, **Add Employee**, and **Apply Leave**.

---

## 🚀 Tech Stack
- **Language:** Java 17
- **Automation:** Selenium WebDriver 4.x, TestNG
- **Build Tool:** Maven
- **Reporting:** Allure Reports
- **CI/CD:** Jenkins
- **Design Pattern:** Page Object Model (POM)

---

## 🧩 Project Structure

orangehrm-automation
│
├── pom.xml
├── Jenkinsfile
├── README.md
├── src
│ ├── main/java/org/bharat882/orangehrm/pages/ # Page Object classes
│ └── test/java/org/bharat882/orangehrm/tests/ # TestNG test classes
│
└── allure-results/ / target/surefire-reports/ # Reports output


---

## ⚙️ Setup Instructions

### 1. Prerequisites
- Java 17+
- Maven 3.9+
- Chrome or Edge browser installed

### 2. Clone & Build
```bash
git clone https://github.com/bharat882/OrangeHRM-Automation.git
cd OrangeHRM-Automation
mvn clean test
3. Generate Allure Report
mvn allure:serve


This will launch an interactive report at http://localhost:port.

💻 Jenkins Integration

Your pipeline (Jenkinsfile) runs:

Checkout source

Build & test with Maven

Generate & publish Allure report

You can view the latest run in Jenkins → Allure Report tab.

✅ Implemented Test Scenarios

🔐 Login Test

👤 Add Employee Test

🌴 Apply Leave Test (data-driven, dynamic date handling)

📸 Screenshots

Include sample Allure or Jenkins screenshots here to make your repo visually strong:

/docs/allure_dashboard.png
/docs/jenkins_pipeline.png

👨‍💻 Author

Bharat Saini
📍 Toronto, ON
📧 heybharatsaini2@gmail.com

🔗 linkedin.com/in/bharatsaini882

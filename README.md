# AutomatedBirthdayMailer

AutomatedBirthdayMailer as the name suggest is the program that will send Wishes automatically to the recipients.

# Customizations Required
**At Path: src\com\java\resources\config\constants.properties

Value to modify in keys: USER, PASSWORD, HOST_IP

**At Path: src\com\java\resources\dataFile\Day.xlsx enter the data under below columns

SERIAL_NO -> Normal serial no.

EMP_ID    -> Employee ID

FIRST_NAME-> Firstname of employee

LAST_NAME -> Lastname of employee

EMAIL_ID  -> Mail id of employee

MONTH     -> Month of Birth

DAY       -> Date of Birth any value from 1-31 based on month

# Optional Customs
One can add any number of Messages and Images, this program fetch Messages and images randomly from the provided ones.

For adding additional messages in constants.properties use prefix as "MSG_"

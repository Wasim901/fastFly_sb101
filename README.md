# fastFly_sb101
Description:

📅🛫 Console-Based Flight Booking System 📋📊

The Console-Based Flight Booking System is a text-based application 📝🖥️ designed to streamline the process of booking, managing, and accessing information about airline flights. It provides a user-friendly interface accessible via a command-line terminal, offering a range of features and functionalities 🛠️📈 to cater to the needs of passengers ✈️👨‍👩‍👧‍👦 and airline personnel ✈️👨‍✈️👩‍✈️.



----------------------------------------------------------------------------------------------------------------------------------------

ER-Diagram:
----------

   +--------+        +--------+           +--------+
   |        |        |        |           |        |
   | Admin  |        | Flight |           |Customer|
   |        |        |        |           |        |
   +---|----+        +--|-----+           +---|----+
       |               |                     |
       | manages       | has                 | makes
       |               |                     |
       V               V                     V
   +---|---+        +--|-----+           +---|----+
   |       |        |       |           |       |
   |AdminID|        |FlightID|           |CustomerID|
   |       |        |       |           |       |
   +-------+        +-------+           +-------+
       |               |                     |
       |               |                     |
       V               V                     V
   +---|---+        +--|-----+           +---|----+
   |       |        |       |           |       |
   | Name  |        |FlightN|           |   Name|
   |       |        |umber  |           |       |
   +-------+        +-------+           +-------+
       |               |                     |
       |               |                     |
       V               V                     V
   +---|---+        +--|-----+           +---|----+
   |       |        |       |           |       |
   |Username|        |Departu|           |Username|
   |       |        |reCity  |           |       |
   +-------+        +-------+           +-------+
       |               |                     |
       |               |                     |
       V               V                     V
   +---|---+        +--|-----+           +---|----+
   |       |        |       |           |       |
   |Password|        |Arrival|           | Password|
   |       |        |City   |           |       |
   +-------+        +-------+           +-------+
                          |
                          |
                          V
                    +--|-----+
                    |       |
                    |  Price|
                    |       |
                    +-------+


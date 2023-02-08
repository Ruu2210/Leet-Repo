# Write your MySQL query statement below
SELECT Email FROM person
group by Email having count(Email) > 1;
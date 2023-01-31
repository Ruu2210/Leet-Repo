# Write your MySQL query statement below

#Using UPDATE and CASE...WHEN
#CASE Format:
#WHEN <condition> THEN <value>,
#WHEN <other condition> THEN <value>
#ELSE <value>
#END AS <column name>

UPDATE salary SET sex = 
	CASE 
		WHEN sex = 'm' THEN 'f'
		ELSE 'm'
	End



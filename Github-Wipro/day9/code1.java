Select
year,
semester,
count(distinct professor_id) as no_of_professor
from schedule
where course_id between 1 and 10 
group by year,semester
order by year asc;

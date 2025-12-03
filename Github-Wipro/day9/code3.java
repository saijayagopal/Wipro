select E.FirstName,
E.LastName,
 D.DepartmentName,
E.Salary
from
 Employees E
JOIN Departments D on E.DepartmentID = D.DepartmentID
where
    E.Salary > (select avg(Salary)
        from Employees
    where DepartmentID = E.DepartmentID
    )
order by E.Salary asc;
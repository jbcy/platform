# JBCY Platform
### Some notes

> * The folder was creating as what we had discussed before
> * **dao** is a package for database modification (we need an interface of an entity/model and then an implement of it)
> * **model** is a package for entities and domain
> * **service** is a package for supporting database modification (if you remember the MVVM architecture, the class in this package is a bit like view-model)
> * **servlet** is a package for controlling the behaviour of web (a bit like control in MVC architecture)
> * **utils** is a package for common method (I change its name from "common" to "utils")

***New file***
> * **.sql** file contains jbcy database which could be import to your local mysql database.
> * **jbcy** contains three tables: 'user', 'peanut', 'records'.
> * **users** contains: 'id', 'name', 'email', 'password', 'role'.
> * **peanuts** contains: 'id', 'user_id', 'points'.
> * **records** contains: 'id', 'user_id', 'statement'.
> * **apps** contains: 'id', 'name', 'users'.
> * **users_apps** contains: 'id', 'user_id', 'app_id', 'join_date'.

***If you have any question or get confused, please text me in whatsapp***


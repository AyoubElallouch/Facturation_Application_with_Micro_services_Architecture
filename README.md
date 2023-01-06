# Facturation_Application_with_Micro_services_Architecture<br>
this application conains:<br>
<ul>
    <li>Client service: to manage clients (CRUD Operations) using rest api </li>
    <li>Product service: to manage products (CRUD Operations) using rest api.</li>
    <li>Facture service: to manage bills (CRUD Operations) using rest api and get necessary data from client-product services using Openfeign dependency.</li>
    <li>Gateway service:  It provides a flexible way of routing requests based on a number of criteria, as well as focuses on cross-cutting concerns such as security, <br>resiliency, and monitoring.</li>
    <li>Discovery service: discovery allows services to find and communicate with each other without hard-coding the hostname and port.</li>
</ul>

<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">
<p> liste des élèves </p>
<ul>
    <#list eleveGom  as e>
        <li>id attribution :${e.id} - eleve: ${e.idEleve} ${e.eleveFirstName} - gommette: ${e.idGom} ${e.gomName} ${e.gomDescription} ${e.gomColor}</li>
    </#list>
</ul>

</body>

</html>

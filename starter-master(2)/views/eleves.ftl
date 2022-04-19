<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">
<p> liste des élèves </p>
<ul>
    <#list eleves as eleve>
        <li>${eleve.id} - ${eleve.firstName} ${eleve.lastName}</li>
    </#list>
</ul>

</body>

</html>

<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">
  <p> Espace professeur</p>
         <p>Espace inscription</p>
        <form action="/professeurs" method="post">

        <div>Prenom:</div>
        <input type="text" name="firstname" required/>
        <br/><br/>
        <div>Nom:</div>
        <input type="text" name="lastname" required/>
        <br/><br/>
        <div>Mot de passe:</div>
        <input type="password" name="password" required/>
        <br/><br/>
        <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
    </form>
  <p> Pour vous connecter, cliquez sur le lien suivant</p>
  <a href="http://localhost:8081/login"> login</a> <br/>

<p> liste des professeurs </p>
<ul>
    <#list professeurs as p>
        <li>${p.id} - ${p.firstName} ${p.lastName}</li>
    </#list>
</ul>

</body>

</html>

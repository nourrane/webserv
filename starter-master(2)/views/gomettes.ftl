<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">
 <h1>Espace gommettes</h1>
  <#if id?? >
      Connexion en cours<br>
         <p>Espace création gommette</p>
        <form action="/gommettes" method="post">

        <div>Nom de la gommette:</div>
        <input type="text" name="name" required/>
        <br/><br/>
        <div>Description de la gommette:</div>
        <textarea type="text" name="description" required/>
        </textarea>
        <br/><br/>
        <div>Couleur de la gommette:</div>
        <input type="text" name="color" required/>
        <br/><br/>
        <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
    </form>
  <#else>
  <p> Pour modifier la liste des gommettes, veillez vous connecter sur la page suivante</p>
  <a href="http://localhost:8081/login"> login</a> <br/>

  </#if>


<p> liste des gommettes </p>
<ul>
  <#list goms as g>
        <li>${g.id} - ${g.name} ${g.description} ${g.color}</li>
    </#list>
</ul>

</body>

</html>

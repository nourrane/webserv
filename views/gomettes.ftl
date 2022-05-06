<#ftl encoding="utf-8">

<body xmlns="http://www.w3.org/1999/html">
  <nav>
      <ul>
          <li><a href="/index">Index</a></li>
          <li><a href="/professeurs">Espace Professeurs</a></li>
          <li><a href="/eleves">Liste Elèves</a></li>
          <li><a href="/gommettes">Liste Gommettes</a></li>
            <li><a href="/elevesGom">Liste d'attribution des gommettes à un élève</a></li>
      </ul>
  </nav>
 <h1>Espace gommettes</h1>


<p> liste des gommettes </p>
<ul>
  <#list goms as g>
        <li>${g.id} - ${g.name} ${g.description} ${g.color}</li>
    </#list>
</ul>

  <#if id?? >
      Connexion en cours<br>
    <p> Pour créer une gommette à la liste, veillez vous connecter sur la page suivante</p>
    <a href="/gommettes/create"> Création d'une gommette</a> <br/>
             
    <p> Pour modifier une gommette de la liste, veillez vous connecter sur la page suivante</p>
    <a href="/gommettes/modify"> Modification d'une gommette</a> <br/>
    <p> Pour supprimer une gommettes de la liste, veillez vous connecter sur la page suivante</p>
    <a href="/gommettes/delete"> Suppression d'une gommette</a> <br/>
    <#else>
  <p> Pour ajouter, modifier ou supprimer une gommette de la liste des gommettes, veillez vous connecter sur la page suivante</p>
  <a href="/login"> login</a> <br/>

  </#if>

</body>

</html>

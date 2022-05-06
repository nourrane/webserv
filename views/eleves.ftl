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
 <h1>Espace élèves</h1>

<p> liste des élèves </p>
<ul>
    <#list eleves as eleve>
        <li>${eleve.id} - ${eleve.firstName} ${eleve.lastName}</li>
    </#list>
</ul>
  <#if id?? >
    Connexion en cours<br>
    <p> Pour créer un élève de la liste, veillez vous connecter sur la page suivante</p>
    <a href="/eleves/create"> Création d'élève</a> <br/>
    <p> Pour modifier un élève de la liste, veillez vous connecter sur la page suivante</p>
    <a href="/eleves/modify"> Modification d'élève</a> <br/>
    <p> Pour supprimer un élève de la liste, veillez vous connecter sur la page suivante</p>
    <a href="/eleves/delete"> Suppression d'élève</a> <br/>
  <#else>
  <p> Pour ajouter, modifier ou supprimer un élève dans la liste des élèves, veillez vous connecter sur la page suivante</p>
  <a href="/login"> login</a> <br/>

  </#if>



</body>

</html>


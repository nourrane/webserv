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
<p> liste des attributions des gommettes à un élève </p>
<ul>
    <#list eleveGom  as e>
        <li>id attribution :${e.id} - eleve: ${e.idEleve} - gommette: ${e.idGom} - date: ${e.date} - motif: ${e.motif}</li>
    </#list>
</ul>
  
  <#if id?? >
    Connexion en cours<br>
    <p> Pour créer la gommette d'un élève de la liste, veillez vous connecter sur la page suivante</p>
    <a href="/elevesGom/create"> Création d'une gommette à un élève</a> <br/>
     <p> Pour supprimer une attribution d'une gommette à un élève de la liste, veillez vous connecter sur la page suivante</p>
    <a href="/elevesGom/delete"> Suppression d'une gommette à un élève</a> <br/>
    <p> Pour recherche toutes les gommettes d'un élève, veuillez vous connecter sur la page suivante</p>
    <a href="/elevesGom/recherche"> Recherche les gommettes d'un élève</a> <br/>

  <#else>
  <p> Pour ajouter ou supprimer la liste des gommettes des élèves, veillez vous connecter sur la page suivante</p>
  <a href="/login"> login</a> <br/>
  </#if>
</body>

</html>

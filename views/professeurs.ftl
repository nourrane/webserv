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
  <p> Espace professeur</p>
<p> Liste des professeurs </p>
<ul>
    <#list professeurs as p>
        <li>${p.id} - ${p.firstName} ${p.lastName}</li>
    </#list>
</ul>
    <a href="/login">Connexion / Déconnexion</a> <br/>
</body>

</html>

<#ftl encoding="utf-8">

<head>
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body xmlns="http://www.w3.org/1999/html">
  <div id="main">
    <br/>

    <header>
        <h1>Espace élèves</h1>
    </header>
    <br/>
   <nav>
      <ul>
          <li><a href="/index"><i class="fa fa-home"></i></a></li>
          <li><a href="/professeurs">Professeurs</a></li>
          <li><a class="active" href="/eleves">Élèves</a></li>
          <li><a href="/gommettes">Gommettes</a></li>
          <li><a href="/elevesGom">Attributions</a></li>
      </ul>
  </nav>


  <article>
          <section>

              <h2 id="liste">
                  Liste des Eleves
              </h2>
              <div class="align">
                  
                      <aside>
                        <ul>
                            <#list eleves as eleve>
                                <li>${eleve.id} - ${eleve.firstName} ${eleve.lastName}</li>
                            </#list>
                        </ul>
                      </aside>
                  
                  <br/>  
              </div>
          </section>

          <section>
            <#if id?? >
              Vous êtes connecté<br>
              <p> Pour créer un élève de la liste, veillez vous connecter sur la page suivante</p>
              <a class="buttons" href="/eleves/create">Création</a> <br/>
              <p> Pour modifier un élève de la liste, veillez vous connecter sur la page suivante</p>
              <a class="buttons" href="/eleves/modify">Modification</a> <br/>
              <p> Pour supprimer un élève de la liste, veillez vous connecter sur la page suivante</p>
              <a class="buttons" href="/eleves/delete">Suppression</a> <br/>
            <#else>
              <p> Pour ajouter, modifier ou supprimer un élève dans la liste des élèves, veillez vous connecter sur la page suivante</p>
              <a class="buttons" href="/login"> login</a> <br/>

            </#if>
      </section>
  </article>
</body>

</html>


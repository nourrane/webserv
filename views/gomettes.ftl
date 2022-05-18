<#ftl encoding="utf-8">

<head>
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body xmlns="http://www.w3.org/1999/html">
  <div id="main">
    <br/>

    <header>
        <h1>Espace gommettes</h1>
    </header>
    <br/>
   <nav>
      <ul>
          <li><a href="/index"><i class="fa fa-home"></i></a></li>
          <li><a href="/professeurs">Professeurs</a></li>
          <li><a href="/eleves">Élèves</a></li>
          <li><a href="/gommettes">Gommettes</a></li>
          <li><a href="/elevesGom">Attributions</a></li>
      </ul>
  </nav>


  <article>
          <section>

              <h2 id="liste">
                  Liste des Gommettes
              </h2>
              <div class="align">
                      <aside>
                        <ul>
                            <#list goms as g>
                                <li>${g.id} - ${g.name} ${g.description} ${g.color}</li>
                            </#list>
                        </ul>
                      </aside>
                  <br/>  
              </div>
          </section>

          <section>

            <#if id?? >
              Vous êtes connectés<br>
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
      </section>
  </article>

</body>

</html>
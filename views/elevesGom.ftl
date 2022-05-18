<#ftl encoding="utf-8">

<head>
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body xmlns="http://www.w3.org/1999/html">
  <div id="main">
    <br/>

    <header>
        <h1>Espace Eleves Gommettes</h1>
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
                Liste des Gommettes d'Eleves
            </h2>
            <div class="align">
                <div class="cont">
                    <aside>
                    <#list eleveGom>
                        <table>
                            <tr>
                                <th>Numéro d'attribution</th>
                                <th>de la gommette</th>
                                <th>pour l'élève</th>
                                <th>par le professeur</th>
                                <th>à la date</th>
                                <th>pour le motif suivant</th>
                            </tr>
                          <#items as e>
                            <tr>
                              <td>${e.id}
                              <td>n°${e.idGom} ${e.gomDescription}
                              <td> ${e.firstNameEleve} ${e.lastNameEleve}
                                <td>${e.firstNameProf} ${e.lastNameProf} 
                              
                              <td>${e.date}
                              <td>${e.motif}
                          </#items>
                      </table>
                      </#list>
                    </aside>
                </div>
                <br/>  
            </div>
        </section>

        <section>
  
  <#if id?? >
    Connexion en cours<br>
    <p> Pour créer la gommette d'un élève de la liste, veillez vous connecter sur la page suivante</p>
    <a href="/elevesGom/create"> Nouvelle attribution d'une gommette à un élève</a> <br/>
     <p> Pour supprimer une attribution d'une gommette à un élève de la liste, veillez vous connecter sur la page suivante</p>
    <a href="/elevesGom/delete"> Suppression d'une gommette à un élève</a> <br/>
    <p> Pour recherche toutes les gommettes d'un élève, veuillez vous connecter sur la page suivante</p>
    <a href="/elevesGom/recherche"> Recherche les gommettes d'un élève</a> <br/>

  <#else>
  <p> Pour ajouter ou supprimer la liste des gommettes des élèves, veillez vous connecter sur la page suivante</p>
  <a href="/login"> login</a> <br/>
  </#if>
          </section>
  </article>
  
</body>

</html>

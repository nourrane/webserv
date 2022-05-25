<#ftl encoding="utf-8">

<head>
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body xmlns="http://www.w3.org/1999/html">
  <div id="main">
    <br/>

    <header>
        <h1>Espace gommettes d'un élève</h1>
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

        <form action="/elevesGom/recherche" method="post">

        <label for="idEleve">Identifiant de l'élève</label>
        <select name="idEleve" required >
            <#list eleves as eleve>
                <option value=${eleve.id}>${eleve.id}</option>
            </#list>
        </select>

        <br/><br/>
        <div class="b">
            <input class="buttons" type="submit" value="Valider"/>
        </div>
        </form>
    <#if eleveChoisi??>
        <section>
              <h2 id="liste">
                  Liste des gommettes de l'élève
              </h2>
              <div class="align">
                  
                      <aside>
                         <#list eleveGomSpe>
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
                  
                  <br/>  
              </div>
        </section>

    </#if>
    <br/>
         <footer>
        <a class="buttons" href="/elevesGom"> Retour</a> 
        </footer><br/>

    </div>

</body>

</html>
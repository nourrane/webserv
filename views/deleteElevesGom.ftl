<#ftl encoding="utf-8">
<head>
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body xmlns="http://www.w3.org/1999/html">
 <div id="main">
    <br/>

        <header>
            <h1>Espace suppression d'une gommette à un élève</h1>
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


        <form action="/elevesGom/delete" method="post">
    <div>
        <div>Identifiant de l'attribution de la gommette à un élève :</div>
        <select name="id" required >
            <#list eleveGom as eg>
                <option value=${eg.id}>${eg.id}</option>
            </#list>
        </select>
            </div>
            <br/>
            <div class="b">
                <input class="buttons" type="submit" value="valider "/>
            </div>
        </form>
        <a href="/elevesGom"> Retour à la page précédente</a> <br/>
    </div>

</body>




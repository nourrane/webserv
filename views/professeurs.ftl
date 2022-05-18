<#ftl encoding="utf-8">

<head>
    <link href="/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>

<body xmlns="http://www.w3.org/1999/html">
    <div id="main">
    <br/>

    <header>
        <h1>Espace professeur</h1>
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
                Liste des Professeurs
            </h2>
            <div class="align">
                <div class="cont">
                    <ul>
                        <#list professeurs as p>
                            <li>${p.id} - ${p.firstName} ${p.lastName}</li>
                        </#list>
                    </ul>
                </div>
                <br/>  
            </div>
        </section>
    <footer>
        <a href="/login">Connexion / Deconnexion</a>
    </footer>  
</body>

</html>

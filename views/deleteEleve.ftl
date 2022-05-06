<#ftl encoding="utf-8">
<head>
    <link href="/deleteEleve.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body xmlns="http://www.w3.org/1999/html">
 <h1>Espace élèves</h1>

         <p>Espace suppression élève</p>
        <form action="/eleves/delete" method="post">

        <label for="id">Identifiant de l'élève</label>
        <br/><br/>
        <select name="id" required >
            <#list eleves as eleve>
                <option value=${eleve.id}>${eleve.id}</option>
            </#list>
        </select>

        <br/><br/>
        <input type="submit" value="Submit"/>
        <input type="reset" value="Reset"/>
    </form>
    <a href="/eleves"> Retour à la page précédente</a> <br/>

</body>

</html>


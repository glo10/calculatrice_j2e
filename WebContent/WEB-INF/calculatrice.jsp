<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Formulaire calculatrice</title>
	
</head>

<body>

	<!-- Resultat de l'opération -->
	<p>Le résultat est : ${!empty(erreur)?erreur:resultat}</p>
	
	<form method="POST" action = "activite_calculatrice/calculatrice">
		<fieldset>
			<legend>Opérations uniquement sur des entiers</legend>
			<input type="number" step="1" name="nb1" placeholder="Saisir un nombre" pattern="[-]?([0-9]){1,}]"/>
			
			<select name="operateur">
				<option value="" disabled selected>Choisir un opérateur</option>
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select>
			
			<input type="number" step="1" name="nb2" placeholder="Saisir un nombre" pattern="[-]?([0-9]){1,}]"/>
			
			<input type="submit" value="calculer"/>
		</fieldset>
	</form>

</body>

</html>
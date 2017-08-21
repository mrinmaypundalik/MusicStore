<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/templates/header.jsp"%>

<!-- Carousel
    ================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
		<li data-target="#myCarousel" data-slide-to="3"></li>
	</ol>
	<div class="carousel-inner" role="listbox">
		<div class="item active">
			<img class="first-slide home-image"
				src="<c:url value="http://wallpapercave.com/wp/EWHbfcC.jpg"/>"
				alt="First slide">
			<div class="container">
				<div class="carousel-caption">
					<h1 class="rainbow-text">Music is Life</h1>

					<p class="rainbow-text">For the Lovers. By the Lovers</p>
				</div>
			</div>
		</div>

		<div class="item">
			<img class="second-slide home-image"
				src="<c:url value="https://s-media-cache-ak0.pinimg.com/originals/e2/03/00/e2030085d3bdf9d812cbea115e098a2b.jpg"/>"
				alt="Second slide">
			<div class="container">
				<div class="carousel-caption"
					style="top: 120px; padding-right: 50px">
					<h4>Eat</h4>
					<br /> <br />
					<h3>Sleep</h3>
					<br /> <br />
					<h2 style="color: red;">
						<strong>Music</strong>
					</h2>
					<br /> <br />
					<h1>Repeat</h1>
				</div>
			</div>
		</div>

		<div class="item">
			<img class="third-slide home-image"
				src="<c:url value="/resources/images/MusicMania_Background.11.jpg"/>"
				alt="Third slide">
			<div class="container">
				<div class="carousel-caption">
					<h1>
						Ear<span style="color: red">gasm</span>
					</h1>

					<p>
						Pleasure for Ears. <span style="background: red">Peace for
							mind.</span>
					</p>
				</div>
			</div>
		</div>

		<div class="item">
			<img class="fourth-slide home-image"
				src="<c:url value="/resources/images/MusicMania_Background.8.jpg"/>"
				alt="First slide">
			<div class="container">
				<div class="carousel-caption">
					<h1>Empty Vessels make more Music</h1>

					<p>Welcome to Music Mania!</p>
				</div>
			</div>
		</div>

	</div>
	<a class="left carousel-control" href="#myCarousel" role="button"
		data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
		aria-hidden="true"></span> <span class="sr-only">Previous</span>
	</a> <a class="right carousel-control" href="#myCarousel" role="button"
		data-slide="next"> <span class="glyphicon glyphicon-chevron-right"
		aria-hidden="true"></span> <span class="sr-only">Next</span>
	</a>
</div>
<!-- /.carousel -->


<!-- Marketing messaging and featurettes
    ================================================== -->
<!-- Wrap the rest of the page in another container to center all the content. -->

<div class="container marketing">

	<!-- Three columns of text below the carousel -->
	<div class="row">
		<div class="col-lg-4">
			<a
				href='<c:url value="/product/productlist/filter?searchCondition=Instrument"/>'
				role="button" class="btn btn-default"><img alt="Instrument"
				class="img-circle"
				src='<c:url value="/resources/images/Instrument.png"/>' width="140"
				height="140"></a>
			<h2>Instrument</h2>
			<p>Create Melody</p>
		</div>
		<div class="col-lg-4">
			<a
				href='<c:url value="/product/productlist/filter?searchCondition=Record"/>'
				role="button" class="btn btn-default"><img alt="Record"
				class="img-circle"
				src='<c:url value="/resources/images/Record.ico"/>' width="140"
				height="140"></a>
			<h2>Record</h2>
			<p>Cherish Music</p>
		</div>
		<div class="col-lg-4">
			<a
				href='<c:url value="/product/productlist/filter?searchCondition=Accessory"/>'
				role="button" class="btn btn-default"><img alt="Accessory"
				style="border-radius: 50%;"
				src='<c:url value="/resources/images/Accessory.png"/>' width="140"
				height="140"></a>
			<h2>Accessory</h2>
			<p>Experience</p>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/templates/footer.jsp"%>
</body>
</html>
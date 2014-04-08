
/* ________________________iMAGE ______________________*/
var Image ={
 rouge : "img/noir.jpg",
 noir  : "img/rouge.jpg"
}

/* ________________________Point Model  ______________________*/
Pion = Backbone.Model.extend({
 initialize: function(options){
    this.img  = options.img
    this.pos   = options.pos
  }
})

/* ________________________Points collection ______________________*/
pions = Backbone.Collection.extend({
 model : Pion,
 // cb est la vue GrposView que je vais passer a ma function 
 // init qui va initialiser la la liste des points sur la 
 // grille . 
 fetch : function(){
   return this.init()
 },
 init: function(){
   // initialise les points sur la grille , exctactement 
   // comme ta fonction java Dans MainActivity .
   // Je l'initialise a 20 , aul lieu de 255, pour 
   // test dans mon code JavaScript
   /*for (int i = 0; i < 5 ; i++) {
			if(i==0){
				images1[i]=casevpose;
			}
			else{
				if(i%2==0){
					images1[i]=prouge;
				}
				else{
					images1[i]=pnoire;
				}
			}
		}
   }*/
   for( var i =0; i< 20 ; i++ ) {
      this.add(new Pion({pos:i, img: ((i%2) ? Image.rouge : Image.noir) }))
   }
   return this
 }
})

/* ________________________Points View ______________________*/


GrposView= Backbone.View.extend({
  tagName: "body",
  events : {
   "click input[type='image']" :"onclick" 
  },
  template: '\
   <tr>\
   {{#rows}}\
   <td><input type="image" src="{{ img }} "  pos ="{{ pos }}" value ="test" >\
   </td>\
   {{/rows}}\
   </tr>\
  ',
  initialize: function(options){
    //la grille va faire 3 colonnes par defaut 
    this.rows = options.rows || 3
    this.pions = new pions().fetch()
  },
  render: function(){
    var i = 0;
    new_pions = []
    self =this
    while (i < parseInt(this.pions.length / this.rows )){
      start = i !== 0 ? i + this.rows : i
      new_pions.push({ rows : this.pions.slice(  start ,  start + this.rows ) })
	i++
    }
    // Mustache https://github.com/janl/mustache.js/
    self.$el.empty()
    new_pions.forEach(function(new_pion){
      self.$el.append(Mustache.render(self.template, new_pion ))
    })
    return self
  },
  onclick :function(e){
    e.preventDefault()
    //Fuck , quelqu'un a clique sur Moi
    var pos  = $(e.target).attr('pos')
    // alert  mon image et mon index 
    var me = this.pions.at(pos)
    alert("Je suis le pion   : " + me.pos + " et je me deplace a la postion 0 ")
    this.pions.at(0).pos = parseInt(me.pos)
    this.pions.at(0).img = me.img
    this.render()
    //Je peux changer de position sur la grille si vous la voulez 
  }
})

/* ________________________Run Apps , Ludo Js______________________*/

$(document).ready(function(){
  //Fire 
  //Allume le moteur
  app   = new GrposView({ el:$("table") })
  app.render()
  console.log("Firing app ")
  app.render()
})
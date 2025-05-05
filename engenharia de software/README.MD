# Atividade 1
 ## Comentar o primeiro trecho do livro Software Engineering at Google, Oreilly

>What precisely do we mean by software engineering? What distinguishes “software engineering” from “programming” or “computer science”? And why would Google have a unique perspective to add to the corpus of previous software engineering literature written over the past 50 years?
> 
>The terms “programming” and “software engineering” have been used interchangeably for quite some time in our industry, although each term has a different emphasis and different implications. University students tend to study computer science and get jobs writing code as “programmers.”
> 
>“Software engineering,” however, sounds more serious, as if it implies the application of some theoretical knowledge to build something real and precise. Mechanical engineers, civil engineers, aeronautical engineers, and those in other engineering disciplines all practice engineering. They all work in the real world and use the application of their theoretical knowledge to create something real. Software engineers also create “something real,” though it is less tangible than the things other engineers create.
> 
>Unlike those more established engineering professions, current software engineering theory or practice is not nearly as rigorous. Aeronautical engineers must follow rigid guidelines and practices, because errors in their calculations can cause real damage; programming, on the whole, has traditionally not followed such rigorous practices. But, as software becomes more integrated into our lives, we must adopt and rely on more rigorous engineering methods. We hope this book helps others see a path toward more reliable software practices.

**Comentário:** no primeiro trecho começamos com o questionamento do que seria de fato a engenharia de software e o que distingue ela da ciência da computação. O termo engenharia soa como algo sério e carrega consigo a ideia de construir algo tangivel, o que distoa da engenharia de software que constroi coisas não tão concretas assim, além disso pelo fato de não ser uma profissão regulamentada ela acaba não seguindo regras tão rigorosas, diferentes das outras engenharias onde normalmente as diretrizes são mais rigidas pois erros nos calculos podem causar grandes danos, é importante destacar também que os cursos na área de tecnologia como a engenharia já citada, ciência da computação e outros possuem diversas áreas de atuação e precisam de costantes atualizações pois as coisas nesse ramo costumam ficar obsoletas mais rápido do que em outros, por fim a maior diferença entre as duas está no fato de que enquanto um progrador foca em escrever um código funcional com base em requisitos específicos, o engenheiro de software projeta, desenvolve e o mais importante, mantém aquele sistema funcional e otmizado.

 # Atividade 2
  ## Comentar o segundo trecho do livro Software Engineering at Google, Oreilly

>Programming Over Time
>We propose that “software engineering” encompasses not just the act of writing code, but all of the tools and processes an organization uses to build and maintain that code over time. What practices can a software organization introduce that will best keep its code valuable over the long term? How can engineers make a codebase more sustainable and the software engineering discipline itself more rigorous? We don’t have fundamental answers to these questions, but we hope that Google’s collective experience over the past two decades illuminates possible paths toward finding those answers.
>
>One key insight we share in this book is that software engineering can be thought of as “programming integrated over time.” What practices can we introduce to our code to make it sustainable—able to react to necessary change—over its life cycle, from conception to introduction to maintenance to deprecation?
> 
>The book emphasizes three fundamental principles that we feel software organizations should keep in mind when designing, architecting, and writing their code:
> 
>Time and Change
>How code will need to adapt over the length of its life
 >
>Scale and Growth
>How an organization will need to adapt as it evolves
> 
>Trade-offs and Costs
>How an organization makes decisions, based on the lessons of Time and Change and Scale and Growth

**Comentário:** no segundo trecho do livro é discutido mais a fundo o tópico já citado anteriormente com algumas reflexões como: o que fazer para perpetuar um código por mais tempo, como torna-lo mais sustentável? é necessário que tanto a organização como os engenheiros tenham isso em mente para construir algo que seja adptavel as mudanças, com um custo baixo e que tradeoffs precisarão ser realizadas

 # Atividade 3
 ## exemplos de tradeoffs

1°  custo x tempo - um código mais detalhado demora mais tempo e é mais caro, pórem prolonga sua vida últil e facilita para outros devs

2° funcionalidade x simplicidade -  adicionar muitas funcionalidades pode deixar o sistema confuso e mais dificil de manter pórem um design simples pode não ter os recursos necessários para alguns usuários

3° portabilidade x desempenho - usar linguagens de alto nível torna mais fácil a construção do código pórem se perde o desempenho que as linguagens de baixo nível possuem

 # Atividade 4
 ## Classe UML

![Diagrama Classe UML](https://github.com/joaoandrade17/Bertoti/blob/main/engenharia%20de%20software/ClasseUML.png)

 # Atividade 5
 ## Java

 ### Classe Livro
```

public class Livro {
    String nome;
    String autor;
    int codigo;

public Livro(String nome, String autor, int codigo) {
    this.nome = nome;
    this.autor = autor;
    this.codigo = codigo;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getAutor() {
    return autor;
}

public void setAutor(String autor) {
    this.autor = autor;
}

public int getCodigo() {
    return codigo;
}

public void setCodigo(int codigo) {
    this.codigo = codigo;
}


}

```
 ### Classe Biblioteca

```

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public void addLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> buscarLivro(String nome){
        List<Livro> encontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getNome().equalsIgnoreCase(nome)) {
                encontrados.add(livro);
            }
        }
        return encontrados;

    }
}

```
 ### Teste
![Teste Java](engenharia de software/Teste classe.png)

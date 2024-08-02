package br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model;

import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.Aluno;
import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.FormaPgto;
import br.edu.ifsul.cc.lpoo.studiodanca.lpoo_studiodanca.model.Pacote;
import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-02T09:15:24", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Contrato.class)
public class Contrato_ { 

    public static volatile SingularAttribute<Contrato, Aluno> aluno;
    public static volatile ListAttribute<Contrato, Pacote> pacotes;
    public static volatile SingularAttribute<Contrato, FormaPgto> forma_pgto;
    public static volatile SingularAttribute<Contrato, Double> valor;
    public static volatile SingularAttribute<Contrato, Integer> id;
    public static volatile SingularAttribute<Contrato, Calendar> dataInicio;

}
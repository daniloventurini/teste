

package visao;


import controle.ItensCompraControle;
import controle.ProdutoControle;
import entidades.Compra;
import entidades.ItensCompra;
import entidades.Produto;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author pos
 */
public class ItensCompraForm extends javax.swing.JDialog {
    private Compra objCompra;
    private ItensCompra objeto;
    private ItensCompraControle controle;
    private ProdutoControle conProd;
   
    private List<Produto> produtos;
    private Produto prod;

    /** Creates new form ItensCompraForm */
    public ItensCompraForm(java.awt.Frame parent, boolean modal, Compra compra) {
        super(parent, modal);
        initComponents();
        controle = ItensCompraControle.getInstance();
        conProd = ProdutoControle.getInstance();
        this.objCompra=compra;
        montaTabela();
        limpaCampos();
        montaCombo();
    }



    public void montaTabela(){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Produto");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Valor");
        modelo.addColumn("SubTotal");
        DecimalFormat nf = new DecimalFormat("#,##0.00");
        for (Iterator<ItensCompra> it = objCompra.getItensCompra().iterator(); it.hasNext();){
            ItensCompra itensCompra = it.next();
            modelo.addRow(new Object[]{itensCompra.getProduto().getNomeProduto(),
            itensCompra.getQuantidade(),nf.format(itensCompra.getValor()), nf.format(itensCompra.getTotal())});
        }
        tabela.setModel(modelo);
    }


    public boolean verificaCampos(){
        if (fQuantidade.getText().equals("") ||
                fQuantidade.getText().equals(null)){
            JOptionPane.showMessageDialog(null,
                    "O campo Quantidade deve ser preenchio!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            fQuantidade.requestFocus();
            return false;
        } else if (cProduto.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null,
                    "O campo Produto deve ser preenchio!",
                    "Atenção", JOptionPane.WARNING_MESSAGE);
            cProduto.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    public void limpaCampos(){
        
        fQuantidade.setText(null);
        cProduto.setSelectedItem(null);
    }

    public ItensCompra getObjeto() {
        return objeto;
    }

    public void setObjeto(ItensCompra objeto) {
        this.objeto = objeto;
    }

    public Compra getObjCompra() {
        return objCompra;
    }

    public void setObjCompra(Compra objCompra) {
        this.objCompra = objCompra;
    }

    public BigDecimal getTotalGeral(){
        BigDecimal totalGeral =new BigDecimal(0);
        for (Iterator<ItensCompra> it = objCompra.getItensCompra().iterator(); it.hasNext();) {
            ItensCompra itens = it.next();
            totalGeral = totalGeral.add(itens.getTotal());

        }
        return totalGeral;
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cProduto = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        fQuantidade = new javax.swing.JTextField();
        bAdicionar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Itens de Compra");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados"));

        jLabel3.setText("Produto:");

        jLabel1.setText("Quantidade:");

        bAdicionar.setText("Adicionar");
        bAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(fQuantidade, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bAdicionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bAdicionar)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens"));

        bRemover.setText("Remover");
        bRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoverActionPerformed(evt);
            }
        });

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bRemover))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(bRemover)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoverActionPerformed

         Object[] options = {"Sim" , "Não"};
        int i = JOptionPane.showOptionDialog(null, "Tem certeza" +
                " que deseja excluir este registro?", "Atenção!",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);
        if (i == JOptionPane.YES_OPTION){
        setObjeto(objCompra.getItensCompra().get(tabela.getSelectedRow()));
        objCompra.getItensCompra().remove(objeto);
        controle.excluir(objeto);

        montaTabela();
        limpaCampos();
        }
    }//GEN-LAST:event_bRemoverActionPerformed

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
       // TODO add your handling code here:
    }//GEN-LAST:event_tabelaMouseClicked

    private void bAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdicionarActionPerformed
        if (verificaCampos() == true){
            objeto = new ItensCompra();
            objeto.setCompra(objCompra);
            objeto.setProduto(produtos.get(cProduto.getSelectedIndex()));
            objeto.setQuantidade(Integer.parseInt(fQuantidade.getText()));
            prod = produtos.get(cProduto.getSelectedIndex());
            objeto.setValor(prod.getValor());
            objeto.setTotal();
            objCompra.getItensCompra().add(objeto);
            montaTabela();
            limpaCampos();
        }
    }//GEN-LAST:event_bAdicionarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdicionar;
    private javax.swing.JButton bRemover;
    private javax.swing.JComboBox cProduto;
    private javax.swing.JTextField fQuantidade;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

    private void montaCombo() {
        produtos = conProd.listaTodos();
        cProduto.removeAllItems();
        for (Iterator<Produto> it = produtos.iterator(); it.hasNext();) {
            Produto produto= it.next();
            cProduto.addItem(produto.getNomeProduto());
    }
    }
}

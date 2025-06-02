/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.llslucas.condominio.view;

import br.llslucas.condominio.controller.CondominioController;
import br.llslucas.condominio.controller.FaturaController;
import br.llslucas.condominio.controller.MoradorController;
import br.llslucas.condominio.controller.ResidenciaController;
import br.llslucas.condominio.model.Condominio;
import br.llslucas.condominio.model.Fatura;
import br.llslucas.condominio.model.Morador;
import br.llslucas.condominio.model.Residencia;
import java.awt.CardLayout;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class ResidenciasView extends javax.swing.JPanel {

  private final CondominioController condominioController;
  private final ResidenciaController residenciaController;
  private final MoradorController moradorController;
  private final FaturaController faturaController;

  private static Long condominioIdFilter = null;

  /**
   * Creates new form ResidenciaView
   *
   * @param condominioController
   * @param residenciaController
   * @param moradorController
   * @param faturacontroller
   */
  public ResidenciasView(CondominioController condominioController, ResidenciaController residenciaController, MoradorController moradorController, FaturaController faturacontroller) {
    initComponents();
    this.condominioController = condominioController;
    this.residenciaController = residenciaController;
    this.moradorController = moradorController;
    this.faturaController = faturacontroller;

    DefaultTableModel model = (DefaultTableModel) table.getModel();
    model.addTableModelListener(evento -> {
      if (evento.getType() == TableModelEvent.UPDATE) {
	this.updateRow();
      }
    });
  }

  public static void setCondominioFilter(Long id) {
    condominioIdFilter = id;
  }

  @Override
  public void setVisible(boolean aFlag) {
    super.setVisible(aFlag);

    if (aFlag) {
      preencherTabela();
    } else {
      condominioIdFilter = null;
    }
  }

  public void updateRow() {
    int row = table.getSelectedRow();

    if (row == -1) {
      return;
    }

    Long id = Long.valueOf((String) table.getValueAt(row, 0));
    String rua = (String) table.getValueAt(row, 1);
    Long numero = (Long) table.getValueAt(row, 2);
    String cep = (String) table.getValueAt(row, 3);
    String tipo = (String) table.getValueAt(row, 4);

    Morador proprietario = (Morador) table.getValueAt(row, 5);
    Long proprietarioId = proprietario != null ? proprietario.getId() : null;

    Long condominioId = ((Condominio) table.getValueAt(row, 6)).getId();

    Residencia residencia = new Residencia(id, rua, numero, cep, tipo, proprietarioId, condominioId);

    try {
      this.residenciaController.update(residencia);
      JOptionPane.showMessageDialog(this, "Residencia atualizada com sucesso!");
      preencherTabela();
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this,
	      "Falha ao excluir a residencia, verifique o erro abaixo: \n" + ex.getMessage(), "Erro",
	      JOptionPane.ERROR_MESSAGE);
    }
  }

  public final void preencherTabela() {
    DefaultTableModel model = (DefaultTableModel) table.getModel();
    table.setModel(model);
    table.selectAll();
    model.setRowCount(0);

    Map<Long, Residencia> residencias;

    try {
      if (condominioIdFilter == null) {
	residencias = residenciaController.list();
      } else {
	residencias = residenciaController.listByCondominio(condominioIdFilter);
      }

      residencias.forEach((i, residencia) -> {
	Morador proprietario;
	Condominio condominio;

	try {
	  if (residencia.getProprietarioId() != null) {
	    proprietario = this.moradorController.getById(residencia.getProprietarioId());
	  } else {
	    proprietario = null;
	  }
	} catch (Exception ex) {
	  proprietario = null;
	}

	try {
	  condominio = this.condominioController.getById(residencia.getCondominioId());
	} catch (Exception ex) {
	  condominio = null;
	}

	Object[] data = {
	  String.valueOf(i),
	  residencia.getRua(),
	  residencia.getNumero(),
	  residencia.getCep(),
	  residencia.getTipo(),
	  proprietario,
	  condominio,
	  getStatusResidencia(i)
	};

	model.addRow(data);
      });
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this,
	      "Não foi possível realizar a conexão com o banco de dados, verifique se está ativo ou se foi configurado corretamente.",
	      "Erro", JOptionPane.ERROR_MESSAGE);
    }
  }

  private String getStatusResidencia(Long id) {
    try {
      for (Map.Entry<Long, Fatura> entry : faturaController.listByResidencia(id).entrySet()) {
	Fatura fatura = entry.getValue();
	if (fatura.getDataVencimento().compareTo(Date.valueOf(LocalDate.now())) < 0) {
	  if (fatura.getStatus().equals("Aberto")) {
	    return "Atrasado";
	  }
	}
      }

      return "Em dia";
    } catch (Exception ex) {
      return null;
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    scrollPane = new javax.swing.JScrollPane();
    table = new javax.swing.JTable();
    jPanel1 = new javax.swing.JPanel();
    btnCadastrar = new javax.swing.JButton();
    btnExcluir = new javax.swing.JButton();
    btnMoradores = new javax.swing.JButton();
    btnLimparFiltro = new javax.swing.JButton();
    btnEditar = new javax.swing.JButton();
    btnFaturas = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();

    setPreferredSize(new java.awt.Dimension(860, 547));

    scrollPane.setMinimumSize(new java.awt.Dimension(715, 16));

    table.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null, null, null, null, null}
      },
      new String [] {
        "id", "Rua", "Número", "CEP", "Tipo", "Proprietario", "Condominio", "Status"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Long.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, true, true, true, true, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    table.setColumnSelectionAllowed(true);
    table.getTableHeader().setReorderingAllowed(false);
    scrollPane.setViewportView(table);
    table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
    if (table.getColumnModel().getColumnCount() > 0) {
      table.getColumnModel().getColumn(0).setResizable(false);
      table.getColumnModel().getColumn(0).setPreferredWidth(50);
    }

    btnCadastrar.setText("Cadastrar");
    btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCadastrarActionPerformed(evt);
      }
    });

    btnExcluir.setText("Excluir");
    btnExcluir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnExcluirActionPerformed(evt);
      }
    });

    btnMoradores.setText("Moradores");
    btnMoradores.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnMoradoresActionPerformed(evt);
      }
    });

    btnLimparFiltro.setText("Limpar Filtro");
    btnLimparFiltro.setActionCommand("Limpar Filtros");
    btnLimparFiltro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLimparFiltroActionPerformed(evt);
      }
    });

    btnEditar.setText("Editar");
    btnEditar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEditarActionPerformed(evt);
      }
    });

    btnFaturas.setText("Faturas");
    btnFaturas.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnFaturasActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(17, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(btnFaturas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnLimparFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnMoradores, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(20, 20, 20))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(20, 20, 20)
        .addComponent(btnCadastrar)
        .addGap(20, 20, 20)
        .addComponent(btnEditar)
        .addGap(20, 20, 20)
        .addComponent(btnExcluir)
        .addGap(20, 20, 20)
        .addComponent(btnMoradores)
        .addGap(20, 20, 20)
        .addComponent(btnFaturas)
        .addGap(18, 18, 18)
        .addComponent(btnLimparFiltro)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
    jLabel1.setText("Residências");
    jLabel1.setMaximumSize(new java.awt.Dimension(848, 20));
    jLabel1.setMinimumSize(new java.awt.Dimension(848, 20));
    jLabel1.setPreferredSize(new java.awt.Dimension(848, 20));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, 0)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void btnLimparFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparFiltroActionPerformed
    condominioIdFilter = null;
    preencherTabela();
  }//GEN-LAST:event_btnLimparFiltroActionPerformed

  private void btnMoradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoradoresActionPerformed
    int row = table.getSelectedRow();

    if (row == -1) {
      JOptionPane.showMessageDialog(this, "Selecione uma linha primeiro!", "Erro", JOptionPane.ERROR_MESSAGE);
      return;
    }

    Long id = Long.valueOf((String) table.getValueAt(row, 0));
    MoradoresView.setResidenciaFilter(id);

    JPanel parent = (JPanel) this.getParent();
    CardLayout layout = (CardLayout) parent.getLayout();
    layout.show(parent, "moradores");
  }//GEN-LAST:event_btnMoradoresActionPerformed

  private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    int row = table.getSelectedRow();

    if (row == -1) {
      JOptionPane.showMessageDialog(this, "Selecione uma linha primeiro!", "Erro", JOptionPane.ERROR_MESSAGE);
      return;
    }

    Long id = Long.valueOf((String) table.getValueAt(row, 0));
    EditaResidenciasView.setId(id);

    JPanel parent = (JPanel) this.getParent();
    CardLayout layout = (CardLayout) parent.getLayout();
    layout.show(parent, "editarResidencias");
  }//GEN-LAST:event_btnEditarActionPerformed

  private void btnFaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFaturasActionPerformed
    int row = table.getSelectedRow();

    if (row == -1) {
      JOptionPane.showMessageDialog(this, "Selecione uma linha primeiro!", "Erro", JOptionPane.ERROR_MESSAGE);
      return;
    }

    Long id = Long.valueOf((String) table.getValueAt(row, 0));
    FaturasView.setResidenciaFilter(id);

    JPanel parent = (JPanel) this.getParent();
    CardLayout layout = (CardLayout) parent.getLayout();
    layout.show(parent, "faturas");
  }//GEN-LAST:event_btnFaturasActionPerformed

  private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCadastrarActionPerformed
    JPanel parent = (JPanel) this.getParent();
    CardLayout layout = (CardLayout) parent.getLayout();
    layout.show(parent, "cadastroResidencias");
  }// GEN-LAST:event_btnCadastrarActionPerformed

  private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnExcluirActionPerformed
    int row = table.getSelectedRow();

    if (row == -1) {
      JOptionPane.showMessageDialog(this, "Selecione uma linha primeiro!", "Erro", JOptionPane.ERROR_MESSAGE);
      return;
    }

    Long id = Long.valueOf((String) table.getValueAt(row, 0));
    Residencia residencia;

    try {
      residencia = this.residenciaController.getById(id);
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "O condomínio selecionado não existe.", "Erro", JOptionPane.ERROR_MESSAGE);
      return;
    }

    int opt = JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o residencia?", "Aviso",
	    JOptionPane.OK_CANCEL_OPTION);

    try {
      if (opt == 0) {
	this.residenciaController.delete(residencia);
	preencherTabela();
      }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this,
	      "Falha ao excluir o residencia, verifique o erro abaixo: \n" + ex.getMessage(), "Erro",
	      JOptionPane.ERROR_MESSAGE);
    }
  }// GEN-LAST:event_btnExcluirActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnCadastrar;
  private javax.swing.JButton btnEditar;
  private javax.swing.JButton btnExcluir;
  private javax.swing.JButton btnFaturas;
  private javax.swing.JButton btnLimparFiltro;
  private javax.swing.JButton btnMoradores;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane scrollPane;
  private javax.swing.JTable table;
  // End of variables declaration//GEN-END:variables
}
